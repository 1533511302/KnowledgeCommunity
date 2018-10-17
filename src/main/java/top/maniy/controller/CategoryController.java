package top.maniy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.entity.Category;
import top.maniy.service.CategoryService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/16 14:27
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("categorise")
    @ResponseBody
    public   List<Category> findAllCategory(){
        return categoryService.findAllCategory();
    }

    @RequestMapping("categorise/{type}")
    @ResponseBody
    public List<Category> findCategory(@PathVariable Integer type,
                                       @RequestParam(value="status", required=false, defaultValue="1") String status){
        return categoryService.findCategoryByTypeAndStatus(type, status);
    }


}
