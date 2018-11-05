package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;
import org.apache.shiro.SecurityUtils;
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
import top.maniy.service.UserService;

import java.util.List;

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

    @Autowired
    private UserService userService;


    @RequestMapping(value = "saveAnswer",method = RequestMethod.POST)
    @ResponseBody
    public boolean addAnswer(@RequestParam Integer quesId, @RequestParam String answerContent
                            ){
        Answer answer =new Answer();
        answer.setQuesId(quesId);
        answer.setAnswerContent(answerContent);
        return answerService.saveAnswer(answer);
    }


    @RequestMapping(value = "deleteAnswer",method = RequestMethod.GET)
    @ResponseBody
    public boolean deleteAnswer(@RequestParam Integer answerId){
        return answerService.deleteAnswer(answerId);
    }

    @RequestMapping(value = "toUpdateAnswer",method = RequestMethod.GET)
    public String toUpdateAnswer(@RequestParam Integer answerId,ModelMap modelMap){

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int userId=userService.findUserByUsername(username).getId();

        Answer answer =answerService.findAnswerById(answerId);

        Question question =questionService.findQuestionById(answer.getQuesId());
        modelMap.put("question",question);
        modelMap.put("answer",answer);
        modelMap.put("userId",userId);
        return "updateAnswerPage";
    }

    @RequestMapping(value = "updateAnswer",method = RequestMethod.POST)
    @ResponseBody
    public boolean updateAnswer(@RequestParam Integer answerId,@RequestParam String answerContent){
        Answer answer =new Answer();
        answer.setId(answerId);
        answer.setAnswerContent(answerContent);
        return answerService.updateAnswer(answer);
    }

}
