package top.maniy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/12/5 10:46
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("categoryList")
    public String categoryList(){
        return "adminCategoryList";
    }


    @RequestMapping("topicList")
    public String topicList(){
        return "adminTopicList";
    }

    @RequestMapping("userList")
    public String userList(){
        return "adminUserList";
    }
}
