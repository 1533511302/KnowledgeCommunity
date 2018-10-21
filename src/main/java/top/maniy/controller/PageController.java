package top.maniy.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.maniy.entity.Massage;
import top.maniy.entity.Topic;
import top.maniy.entity.User;
import top.maniy.mapper.MassageMapper;
import top.maniy.service.MassageService;
import top.maniy.service.TopicService;
import top.maniy.service.UserService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/18 9:37
 */
@Controller
public class PageController {

    @Autowired
    private MassageService massageService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toIndex",method = RequestMethod.GET)
    public String toIndex(ModelMap modelMap){
        //热门文章前五
        List<Massage> hotMassageList =massageService.findMassageByBrowseNumbDesc0To5();
        //最新文章前五
        List<Massage> newMassageList=massageService.findMassageByCreateTimeDesc0To5();
        //随机4个话题
        List<Topic> randTopicList=topicService.findTopicRandTo4();
        //热门认证用户前三 by文章数
        List<User> hotUserList=userService.findUserByRoleAndMassageNumbDescTo3();
        //文章大于或等于1新认证用户前三 bycreateTime
        List<User> newUserList=userService.findUserByRoleAndByMassageNumbAndCreateTimeDesc();
        modelMap.put("newUserList",newUserList);
        modelMap.put("hotUserList",hotUserList);
        modelMap.put("randTopicList",randTopicList);
        modelMap.put("hotMassageList",hotMassageList);
        modelMap.put("newMassageList",newMassageList);

        return "index";
    }


}
