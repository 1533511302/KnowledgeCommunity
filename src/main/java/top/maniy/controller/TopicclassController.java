package top.maniy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.entity.Topicclass;
import top.maniy.service.TopicclassService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/17 23:08
 */
@Controller
public class TopicclassController {

    @Autowired
    private TopicclassService topicclassService;

    @RequestMapping(value = "/topicClass",method = RequestMethod.GET)
    @ResponseBody
    public List<Topicclass> findAllTopicClass(){
        return topicclassService.findAllTopicclass();
    }

    @RequestMapping(value = "/topicClass/ids")
    @ResponseBody
    public List<Topicclass> findSomeTopicClass(Integer [] ids){
        return  topicclassService.findSomeTopicclass(ids);
    }

    @RequestMapping(value = "/topicClass",method = RequestMethod.POST)
    @ResponseBody
    public boolean saveTopicClass(Topicclass topicclass){
        return topicclassService.saveTopicclass(topicclass);
    }


}
