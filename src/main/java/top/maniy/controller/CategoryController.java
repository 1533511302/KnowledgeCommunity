package top.maniy.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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

    @RequestMapping("saveCategory")
    @ResponseBody
    @RequiresPermissions("category:insert")
    public boolean saveCategory(@RequestParam("categoryName") String categoryName,
                                @RequestParam("categoryType") Integer categoryType,
                                @RequestParam("status") String status){
        Category category =new Category();
        category.setCategoryName(categoryName);
        category.setCategoryType(categoryType);
        category.setStatus(status);
       return categoryService.saveCategory(category);
    }

    @RequestMapping("updateCategory")
    @ResponseBody
    @RequiresPermissions("category:update")
    public boolean updateCategory(@RequestParam("id") Integer id,@RequestParam("categoryName") String categoryName,
                                  @RequestParam("categoryType") Integer categoryType,
                                  @RequestParam("status") String status){
        Category category=categoryService.findCategoryById(id);
        category.setCategoryName(categoryName);
        category.setCategoryType(categoryType);
        category.setStatus(status);
        return categoryService.updateCategory(category);
    }

    @RequestMapping("deleteCategory")
    @ResponseBody
    @RequiresPermissions("category:update")
    public boolean deleteCategory(@RequestParam("id") Integer id){
        return categoryService.deleteCategory(id);
    }
}
