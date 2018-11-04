package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.maniy.entity.Answer;
import top.maniy.entity.Category;
import top.maniy.entity.Question;
import top.maniy.entity.Topic;
import top.maniy.service.AnswerService;
import top.maniy.service.QuestionService;
import top.maniy.service.TopicService;

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

    /**
     * 问题列表
     * @param topicId
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping("/questionList/{topicId}")
    public String findQuestionByTopicId(@PathVariable String  topicId,
                                        @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                        @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                                        ModelMap modelMap){
        PageInfo<Question> pageInfo=questionService.findQuestionByTopicId(topicId,page,pageSize);
        Topic topic =topicService.findTopicById(Integer.valueOf(topicId));
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("topic",topic);
        return "questionList";
    }

    /**
     * 问题查询列表
     * @param topicId
     * @param title
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping("/questionList/{topicId}/likeName")
    public String findQuestionBySearch(@PathVariable String  topicId,@RequestParam("title") String title,
                                        @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                        @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                                        ModelMap modelMap){
        PageInfo<Question> pageInfo=questionService.findQuestionByTopicId(topicId,page,pageSize);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("topicId",topicId);
        modelMap.put("title",title);
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
        //话题
        PageInfo<Topic> topicList=topicService.findAllTopic(1,20);
        Question question=questionService.findQuestionById(quesId);
        PageInfo<Answer> pageInfo =answerService.findAnswerByQuesId(quesId,page,pageSize);
        modelMap.put("topicList",topicList);
        modelMap.put("question",question);
        modelMap.put("pageInfo",pageInfo);
        return "questionPage";
    }

    @RequestMapping(value = "saveQuestion",method = RequestMethod.POST)
    @ResponseBody
    public boolean SaveQuestion(@RequestParam String topicId,@RequestParam String quesName,@RequestParam String quesDescribe){
        Question question =new Question();
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

    @RequestMapping(value = "toUpdateQuestion",method = RequestMethod.GET)
    public String toUpdateQuestion(@RequestParam Integer questionId,ModelMap modelMap){
        List<Topic> topicList =topicService.findAllTopic();
        Question question =questionService.findQuestionById(questionId);
        modelMap.put("question",question);
        modelMap.put("topicList",topicList);
        return "updateQuestion";
    }


}
