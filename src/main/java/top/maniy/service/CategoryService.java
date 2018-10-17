package top.maniy.service;

import top.maniy.entity.Category;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/10/16 14:16
 */
public interface CategoryService {

    //查询全部目录
    List<Category> findAllCategory();
    //根据类型和状态查询目录
    List<Category> findCategoryByTypeAndStatus(Integer type,String status);
    //添加目录
    boolean saveCategory(Category category);
    //删除目录
    boolean deleteCategory(Integer id);
    //修改目录
    boolean updateCategory(Category category);
}
