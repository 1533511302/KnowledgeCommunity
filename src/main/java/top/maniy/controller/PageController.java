package top.maniy.controller;


import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.Form.CountForm;
import top.maniy.entity.*;

import top.maniy.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @Autowired
    private AudioService audioService;

    @Autowired
    private QuestionService questionService;


    @RequestMapping(value = "/toIndex",method = RequestMethod.GET)

    public String toIndex(ModelMap modelMap){
        //点赞量最多的4篇文章
        List<Massage> likeMassageList =massageService.findMassageByLikeNumbDesc0To4();
        //热门文章前五
        List<Massage> hotMassageList =massageService.findMassageByBrowseNumbDesc0To5();
        //最新文章前五
        List<Massage> newMassageList=massageService.findMassageByCreateTimeDesc0To5();
        //随机4个话题
        List<Topic> randTopicList=topicService.findTopicRandTo4();
        //随机4个音频
        List<Audio> audioList=audioService.findAudioRandTo4();
        //热门认证用户前三 by文章数
        List<User> hotUserList=userService.findUserByRoleAndMassageNumbDescTo3();
        //文章大于或等于1新认证用户前三 bycreateTime
        List<User> newUserList=userService.findUserByRoleAndByMassageNumbAndCreateTimeDesc();
        modelMap.put("likeMassageList",likeMassageList);
        modelMap.put("audioList",audioList);
        modelMap.put("newUserList",newUserList);
        modelMap.put("hotUserList",hotUserList);
        modelMap.put("randTopicList",randTopicList);
        modelMap.put("hotMassageList",hotMassageList);
        modelMap.put("newMassageList",newMassageList);

        return "index";
    }

    @RequestMapping(value = "music")
    public String musicPage(ModelMap modelMap){
        return "music";
    }


    @RequestMapping(value = "toAdminIndex")
    public String toAdminIndex(ModelMap modelMap){
        return "adminIndex";
    }

    @RequestMapping(value = "toPay")
    public String toPay(){
        return "testPay";
    }


    @RequestMapping(value = "index_v1")
    public String toIndex_v1(){
        return "index_v1";
    }

    //获取登录的管理员信息
    @RequestMapping(value = "adminInfo")
    @ResponseBody
    public User adminInfo(HttpServletRequest request){
        return (User) request.getSession().getAttribute("User");
    }

    //管理主页统计
    @RequestMapping("indexCount")
    @ResponseBody
    public List<CountForm> indexCount(){
        List<CountForm> countFormList =new ArrayList<>();
        CountForm countForm1 =new CountForm();
        countForm1.setLabel("user");
        countForm1.setValue(userService.findUserCount());
        countFormList.add(countForm1);

        CountForm countForm2= new CountForm();
        countForm2.setLabel("massage");
        countForm2.setValue(massageService.findMassageCount());
        countFormList.add(countForm2);

        CountForm countForm3= new CountForm();
        countForm3.setLabel("audio");
        countForm3.setValue(audioService.findAudioCount());
        countFormList.add(countForm3);

        CountForm countForm4= new CountForm();
        countForm4.setLabel("question");
        countForm4.setValue(questionService.findQuestionCount());
        countFormList.add(countForm4);

        return countFormList;
    }


}
