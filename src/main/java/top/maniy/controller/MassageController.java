package top.maniy.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.maniy.entity.Massage;
import top.maniy.service.MassageService;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/16 16:31
 */
@Controller
public class MassageController {

    @Autowired
    private MassageService massageService;

    @RequestMapping(value = "/massages/{id}")
    public String findMassageById(@PathVariable Integer id,ModelMap modelMap){
        Massage massage= massageService.findMassageById(id);
        modelMap.put("massage",massage);
        return "massage";
    }


    @RequestMapping(value = "/categoryId/{categoryId}/massages")
    public String massagePageInfo(@PathVariable Integer categoryId,
                                  @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                  ModelMap modelMap){
        PageInfo<Massage> pageInfo = massageService.findMassageByCategoryId(categoryId,page,5);

        modelMap.put("categoryId",categoryId);
        modelMap.put("pageInfo",pageInfo);
        return "massageList";
    }

    @RequestMapping(value = "/massages",method = RequestMethod.POST)
    @ResponseBody
    public boolean saveMassage(@RequestParam Integer type ,@RequestParam String title,@RequestParam String content){
        Massage massage =new Massage();
        massage.setCategoryId(type);
        massage.setTitle(title);
        massage.setContent(content);
        return massageService.saveMassage(massage);
    }


}
