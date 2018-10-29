package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.maniy.entity.Answer;
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





}
