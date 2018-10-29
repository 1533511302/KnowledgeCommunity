package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.maniy.entity.Answer;
import top.maniy.entity.Question;
import top.maniy.entity.Topic;
import top.maniy.service.AnswerService;
import top.maniy.service.QuestionService;
import top.maniy.service.TopicService;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/29 12:22
 */
@Controller
public class AnswerController {

    @Autowired
    private AnswerService answerService;
    @Autowired
    private QuestionService questionService;

    @Autowired
    private TopicService topicService;


    @RequestMapping(value = "addAnswer/{quesId}",method = RequestMethod.POST)
    public String addAnswer(@PathVariable Integer quesId,@RequestParam("answerContent") String answerContent,
                            @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                            @RequestParam(value="pageSize", required=false, defaultValue="5") Integer pageSize,
                            ModelMap modelMap){
        Answer answer =new Answer();
        answer.setQuesId(quesId);
        answer.setAnswerContent(answerContent);
        answerService.saveAnswer(answer);

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
