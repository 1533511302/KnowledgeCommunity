package top.maniy.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.maniy.Form.QuestionForm;
import top.maniy.entity.*;
import top.maniy.service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/24 16:44
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserService userService;

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private LabelService labelService;

    /**
     * 问题列表
     * @param topicId
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping("/questionList/{topicId}")
    public String findQuestionByTopicId(@PathVariable Integer  topicId,
                                        @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                        @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                                        ModelMap modelMap){
        //话题
        PageInfo<Topic> topicList=topicService.findAllTopic(1,20);
        //问题
        PageInfo<Question> pageInfo=questionService.findQuestionByTopicId(String.valueOf(topicId),page,pageSize);
        //话题中点赞量最多的4个问题
        List<Question> likeQuestionList =questionService.findQuestionByLikeNumbDesc0To4(topicId);
        Topic topic =topicService.findTopicById(topicId);
        List<Label> labelList =labelService.findQuestionLabelByHot(20);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("topic",topic);
        modelMap.put("labelList",labelList);
        modelMap.put("topicList",topicList);
        modelMap.put("likeQuestionList",likeQuestionList);
        return "questionList";
    }

    /**
     * 问题查询列表
     * @param title
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping("/questionList/likeName")
    public String findQuestionBySearch(@RequestParam("title") String title,
                                        @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                        @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                                        ModelMap modelMap){
        //title不为空
        if(title!="" && title!=null) {
            //查询是否存在
            Label label = labelService.findLabelByQuestionLabel(title);
            if (label == null) {//不存在加标签
                labelService.saveQuestionLabel(title);
            } else {
                //存在的话，该标签热度加一
                label.setQuestionLabelHot(label.getQuestionLabelHot() + 1);
                labelService.updateLabel(label);
            }
        }
        PageInfo<Question> pageInfo=questionService.findQuestionLikeQuesName(title,page,pageSize);
        List<Label> labelList =labelService.findQuestionLabelByHot(20);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("title",title);
        modelMap.put("labelList",labelList);
        return "questionListBySearch";
    }

    /**
     * 问题详情页
     * @param quesId
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping("question/{quesId}")
    public String questionPage(@PathVariable Integer quesId,@RequestParam(value="page", required=false, defaultValue="1") Integer page,
                               @RequestParam(value="pageSize", required=false, defaultValue="5") Integer pageSize,
                               ModelMap modelMap){
        //浏览量加一
        questionService.browseNumb(quesId);
        //话题
        PageInfo<Topic> topicList=topicService.findAllTopic(1,20);
        Question question=questionService.findQuestionById(quesId);
        PageInfo<Answer> pageInfo =answerService.findAnswerByQuesId(quesId,page,pageSize);
        //热门认证用户前三 by文章数
        List<User> hotUserList=userService.findUserByRoleAndMassageNumbDescTo3();
        //文章大于或等于1新认证用户前三 bycreateTime
        List<User> newUserList=userService.findUserByRoleAndByMassageNumbAndCreateTimeDesc();
        modelMap.put("newUserList",newUserList);
        modelMap.put("hotUserList",hotUserList);
        modelMap.put("topicList",topicList);
        modelMap.put("question",question);
        modelMap.put("pageInfo",pageInfo);
        return "questionPage";
    }

    /**
     * ajax加载回答
     * @param quesId
     * @param page
     * @return
     */
    @RequestMapping(value = "answerListByQuestionId/{quesId}",method = RequestMethod.POST)
    @ResponseBody
    public List<Answer> questionPageAnswerList(@PathVariable Integer quesId, Integer page){
        PageInfo<Answer> pageInfo =answerService.findAnswerByQuesId(quesId,page,5);
        List<Answer> answerList =pageInfo.getList();
        return answerList;
    }

    /**
     * ajax添加回答
     * @param topicId
     * @param quesName
     * @param quesDescribe
     * @return
     */
    @RequestMapping(value = "saveQuestion",method = RequestMethod.POST)
    @ResponseBody
    public boolean SaveQuestion(@RequestParam String topicId, HttpServletRequest request, @RequestParam(value = "photo",required = false) MultipartFile photo,
                                @RequestParam String quesName, @RequestParam String quesDescribe){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int userId =userService.findUserByUsername(username).getId();

        Question question =new Question();
        question.setUserId(userId);
        question.setTopicId(topicId);
        question.setQuesName(quesName);
        question.setQuesDescribe(quesDescribe);

        if(photo!=null){
            String name = UUID.randomUUID().toString().replaceAll("-", "");
            String fileName=photo.getOriginalFilename();// 文件原名称
            //获取上传文件的目录
            String path=request.getSession().getServletContext().getRealPath("/");
            String newPath= null;
            try {
                newPath = path.substring(0,path.indexOf("KnowledgeCommunity"))+"images\\";
            } catch (Exception e) {
                e.printStackTrace();
                throw new MailSendException("图片路径不正确");
            }
            //获取图片后缀
            String ext= FilenameUtils.getExtension(fileName);
            //新图片
            File newfile =new File(newPath+ name+"."+ext);
            //把内存图片写入磁盘中

            try {
                photo.transferTo(newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            question.setPhoto(name+"."+ext);
        }else {
            question.setPhoto("191ea1c12d824851ade02cfcf0e61e31.jpg");
        }


        return questionService.saveQuestion(question);
    }

    /**
     * 删除问题
     * @param questionId
     * @return
     */
    @RequestMapping(value = "deleteQuestion",method = RequestMethod.GET)
    @ResponseBody
    public boolean deleteQuestion(@RequestParam Integer questionId){
        return questionService.deleteQuestion(questionId);
    }

    /**
     * 加载更新界面
     * @param questionId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "toUpdateQuestion",method = RequestMethod.GET)
    public String toUpdateQuestion(@RequestParam Integer questionId,ModelMap modelMap){

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int userId=userService.findUserByUsername(username).getId();

        List<Topic> topicList =topicService.findAllTopic();
        Question question =questionService.findQuestionById(questionId);
        modelMap.put("question",question);
        modelMap.put("topicList",topicList);
        modelMap.put("userId",userId);
        return "updateQuestionPage";
    }

    /**
     * 更新操作
     * @param questionId
     * @param topicId
     * @param quesName
     * @param quesDescribe
     * @return
     */
    @RequestMapping(value = "updateQuestion",method = RequestMethod.POST)
    @ResponseBody
    public boolean updateQuestion(@RequestParam Integer questionId,@RequestParam String topicId,
                                  @RequestParam String quesName,@RequestParam String quesDescribe){
        Question question =new Question();
        question.setId(questionId);
        question.setTopicId(topicId);
        question.setQuesName(quesName);
        question.setQuesDescribe(quesDescribe);
        System.out.println(question.getId());
        return questionService.updateQuestion(question);
    }

    @RequestMapping(value = "questionAddLikeNumb",method = RequestMethod.POST)
    @ResponseBody
    public boolean questionAddLikeNumb(@RequestParam Integer questionId){
        return questionService.LikeNumbAddOne(questionId);
    }


    /**
     * 问题收藏
     * @param modelMap
     * @param request
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "collectionQuestion",method = RequestMethod.GET)
    public String collectionQuestion(ModelMap modelMap, HttpServletRequest request,
                                    @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                    @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize){
        User user =((User)request.getSession().getAttribute("User"));
        List<Collections> collectionsList =collectionService.findCollectionByTypeIsQuestion(user.getId());
        PageInfo<Question> pageInfo =questionService.findQuestionByUserCollection(collectionsList,page,pageSize);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("user",user);
        return "collectionQuestion";
    }

    @RequestMapping("findAllQuestion")
    @ResponseBody
    public List<QuestionForm> findAllQuestion(){
        List<Question> questionList =questionService.findAllQuestion();
        List<QuestionForm> questionFormList =new ArrayList<>();
        for(Question question:questionList){
            QuestionForm questionForm =new QuestionForm();
            questionForm.setId(question.getId());
            questionForm.setAnswerNumb(question.getAnswerNumb());
            questionForm.setAttentionNumb(question.getAttentionNumb());
            questionForm.setBrowseNumb(question.getBrowseNumb());
            questionForm.setCreateTime(question.getCreateTime());
            questionForm.setLikeNumb(question.getLikeNumb());
            questionForm.setQuesName(question.getQuesName());
            questionForm.setQuesDescribe(question.getQuesDescribe());
            questionForm.setTopic(topicService.findTopicById(Integer.valueOf(question.getTopicId())).getTopicName());
            questionForm.setUsername(userService.findUserById(question.getUserId()).getUsername());
            questionForm.setStatus(question.getStatus());
            questionFormList.add(questionForm);
        }
        return questionFormList;
    }


    @RequestMapping("adminUpdateQuestion")
    @ResponseBody
    public boolean adminUpdateQuestion(@RequestParam("id") Integer id,@RequestParam("status") String status){
        Question question =new Question();
        question.setId(id);
        question.setStatus(status);
        return questionService.updateQuestion(question);
    }

}
