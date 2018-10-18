package top.maniy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/18 9:37
 */
@Controller
public class PageController {

    @RequestMapping(value = "/toIndex",method = RequestMethod.GET)
    public String toIndex(){
        return "index";
    }

    @RequestMapping(value = "/toMassage",method = RequestMethod.GET)
    public String toMassage(){
        return "massage";
    }

    @RequestMapping(value = "/toMassageList",method = RequestMethod.GET)
    public String toMassageList(){
        return "massageList";
    }

    @RequestMapping(value = "/toVUserList",method = RequestMethod.GET)
    public String toCategory(){
        return "vUserList";
    }

    @RequestMapping(value = "/toUserCategory",method = RequestMethod.GET)
    public String toUserCategory(){
        return "userCategory";
    }

    @RequestMapping(value = "/toQuestionList",method = RequestMethod.GET)
    public String toQuestionList(){
        return "questionList";
    }

    @RequestMapping(value = "/toEditMassage",method = RequestMethod.GET)
    public String toEditMassage(){
        return "editMassage";
    }
}
