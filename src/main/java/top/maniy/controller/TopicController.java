package top.maniy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
                               @RequestParam(value = "pageSize",required = false,defaultValue = "12") int pageSize,
                               ModelMap modelMap){
        return "topicList";
    }

}
