package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.maniy.entity.Topic;
import top.maniy.service.TopicService;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/20 14:49
 */
@Controller
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("topics/{page}")
    public String findAllTopic(@PathVariable(value = "page") int page,
                               @RequestParam(value = "pageSize",required = false,defaultValue = "8") int pageSize,
                               ModelMap modelMap){
        PageInfo<Topic> pageInfo =topicService.findAllTopic(page,pageSize);
        modelMap.put("pageInfo",pageInfo);
        return "topicList";
    }

    @RequestMapping("topics/likeName")
    public String findTopicLikeName(@RequestParam(value = "page",required = false,defaultValue = "1") int page,@RequestParam("name") String name,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "8") int pageSize,
                                    ModelMap modelMap){
        PageInfo<Topic> pageInfo =topicService.findTopicLikeName(name,page,pageSize);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("name",name);
        return "topicList";
    }

}
