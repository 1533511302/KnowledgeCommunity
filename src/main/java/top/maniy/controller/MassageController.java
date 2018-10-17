package top.maniy.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.entity.Massage;
import top.maniy.service.MassageService;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/16 16:31
 */
@Controller
@RequestMapping("/api/v1")
public class MassageController {

    @Autowired
    private MassageService massageService;

    @RequestMapping(value = "/massages/{id}")
    @ResponseBody
    public Massage findMassageById(@PathVariable Integer id){
        return massageService.findMassageById(id);
    }


    @RequestMapping(value = "/categoryId/{categoryId}/massages")
    @ResponseBody
    public PageInfo<Massage> massagePageInfo(@PathVariable Integer categoryId,
    @RequestParam(value="page", required=false, defaultValue="1") Integer page){
        return massageService.findMassageByCategoryId(categoryId,page,10);
    }
}
