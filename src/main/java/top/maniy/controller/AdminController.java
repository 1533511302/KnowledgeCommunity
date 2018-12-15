package top.maniy.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    @RequiresPermissions("all:all")
    public String categoryList(){
        return "adminCategoryList";
    }


    @RequestMapping("topicList")
    @RequiresPermissions("all:all")
    public String topicList(){
        return "adminTopicList";
    }

    @RequestMapping("userList")
    @RequiresPermissions("all:all")
    public String userList(){
        return "adminUserList";
    }

    @RequestMapping("userCount")
    @RequiresPermissions("all:all")
    public String userCount(){
        return "adminUserCount";
    }

    @RequestMapping("labelCount")
    @RequiresPermissions("all:all")
    public String  labelCount(){
        return "adminLabelCount";
    }

    @RequestMapping("massageList")
    @RequiresPermissions("all:all")
    public String massageCount(){
        return "adminMassageList";
    }

    @RequestMapping("audioList")
    @RequiresPermissions("all:all")
    public String massageList(){
        return "adminAudioList";
    }

    @RequestMapping("questionList")
    @RequiresPermissions("all:all")
    public String questionList(){
        return "adminQuestionList";
    }
}
