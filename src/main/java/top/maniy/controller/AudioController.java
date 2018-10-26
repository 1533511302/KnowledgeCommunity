package top.maniy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/25 23:20
 */
@Controller
public class AudioController {

    @RequestMapping(value = "/audioPage")
    public String audioPage(){
        return "audioPage";
    }

}
