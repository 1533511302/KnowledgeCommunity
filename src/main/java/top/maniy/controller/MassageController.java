package top.maniy.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.maniy.entity.Category;
import top.maniy.entity.Massage;
import top.maniy.service.CategoryService;
import top.maniy.service.MassageService;

import java.util.List;

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

    @Autowired
    private CategoryService categoryService;

    /**
     * 图文详情页
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/massages/{id}")
    public String findMassageById(@PathVariable Integer id,ModelMap modelMap){
        Massage massage= massageService.findMassageById(id);
        modelMap.put("massage",massage);
        return "massage";
    }

    /**
     * 图文主页
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/massagePage")
    public String massagePage(ModelMap modelMap){
        List<Massage> massageList=massageService.findMassageRandTo10();
        List<Category> categoryList=categoryService.findAllCategory();
        modelMap.put("massageList",massageList);
        modelMap.put("categoryList",categoryList);
        return "massagesPage";
    }

    /**
     * 图文分类页
     * @param categoryId
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/categoryId/{categoryId}/massages")
    public String findMassageByCategoryId(@PathVariable Integer categoryId,
                                  @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                  @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                                  ModelMap modelMap){
        PageInfo<Massage> pageInfo = massageService.findMassageByCategoryId(categoryId,page,pageSize);

        modelMap.put("categoryId",categoryId);
        modelMap.put("pageInfo",pageInfo);
        return "massageList";
    }

    /**
     *根据标题模糊查询图文
     * @param page
     * @param pageSize
     * @param title
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/massages/likeName")
    public String massagePageInfo(@RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                  @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                                  @RequestParam("title") String title,ModelMap modelMap){
        PageInfo<Massage> pageInfo = massageService.findMassageLikeTitle(title,page,pageSize);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("title",title);
        return "massageListBySearch";
    }

    /**
     * 添加图文
     * @param type
     * @param title
     * @param content
     * @return
     */
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
