package top.maniy.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.maniy.entity.*;
import top.maniy.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        PageInfo<Question> pageInfo=questionService.findQuestionByTopicId(String.valueOf(topicId),page,pageSize);
        Topic topic =topicService.findTopicById(topicId);
        List<Label> labelList =labelService.findQuestionLabelByHot(20);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("topic",topic);
        modelMap.put("labelList",labelList);
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
    public boolean SaveQuestion(@RequestParam String topicId,@RequestParam String quesName,@RequestParam String quesDescribe){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int userId =userService.findUserByUsername(username).getId();

        Question question =new Question();
        question.setUserId(userId);
        question.setTopicId(topicId);
        question.setQuesName(quesName);
        question.setQuesDescribe(quesDescribe);
        return questionService.saveQuestion(question);
    }


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

}
