package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;
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


    @RequestMapping(value = "saveAnswer",method = RequestMethod.POST)
    @ResponseBody
    public boolean addAnswer(@RequestParam Integer quesId, @RequestParam String answerContent
                            ){
        Answer answer =new Answer();
        answer.setQuesId(quesId);
        answer.setAnswerContent(answerContent);
        return answerService.saveAnswer(answer);
    }

}
