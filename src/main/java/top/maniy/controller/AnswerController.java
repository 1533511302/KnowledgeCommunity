package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.maniy.entity.Answer;
import top.maniy.entity.Question;
import top.maniy.entity.Topic;
import top.maniy.entity.User;
import top.maniy.service.AnswerService;
import top.maniy.service.QuestionService;
import top.maniy.service.TopicService;
import top.maniy.service.UserService;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 添加回答
     * @param quesId
     * @param answerContent
     * @return
     */
    @RequestMapping(value = "saveAnswer",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("answer:insert")
    public String addAnswer(HttpServletRequest request, @RequestParam Integer quesId, @RequestParam String answerContent){

        User user = (User) request.getSession().getAttribute("User");

        //用户音频数加一
        User user1=userService.findUserById(user.getId());
        user1.setAudionumb(user1.getAudionumb()+1);
        userService.updateUser(user1);

        Answer answer =new Answer();
        answer.setQuesId(quesId);
        answer.setUserId(user.getId());
        answer.setUsername(user.getUsername());
        answer.setPhoto(user.getPhoto());
        answer.setAnswerContent(answerContent);
        if(answerService.saveAnswer(answer)){
            return "1";
        }
        return "2";
    }

    /**
     * 删除回答
     * @param answerId
     * @return
     */
    @RequestMapping(value = "deleteAnswer",method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions("answer:delete")
    public boolean deleteAnswer(@RequestParam Integer answerId){
        return answerService.deleteAnswer(answerId);
    }

    /**
     * 修改回答页面
     * @param answerId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "toUpdateAnswer",method = RequestMethod.GET)
    @RequiresPermissions("answer:update")
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

    /**
     * 修改回答
     * @param answerId
     * @param answerContent
     * @return
     */
    @RequestMapping(value = "updateAnswer",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("answer:update")
    public boolean updateAnswer(@RequestParam Integer answerId,@RequestParam String answerContent){
        Answer answer =new Answer();
        answer.setId(answerId);
        answer.setAnswerContent(answerContent);
        return answerService.updateAnswer(answer);
    }

}
