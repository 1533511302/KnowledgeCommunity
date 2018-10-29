package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.entity.Answer;
import top.maniy.service.AnswerService;

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

    @RequestMapping(value = "addAnswerList",method = RequestMethod.POST)
    @ResponseBody
    public String answerPageInfo(){
        System.out.println(1);


        return "answerService.findAnswerByQuesId(1,1,5)";
    }
}
