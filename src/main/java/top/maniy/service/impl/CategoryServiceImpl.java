package top.maniy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Category;
import top.maniy.mapper.CategoryMapper;
import top.maniy.service.CategoryService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/10/16 14:17
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAllCategory() {
        return categoryMapper.findAllCategory();
    }

    @Override
    public Category findCategoryById(Integer id) {
        return categoryMapper.findCategoryById(id);
    }

    @Override
    public List<Category> findCategoryByTypeRandNum(Integer categoryType, Integer num) {
        return categoryMapper.findCategoryByTypeRandNum(categoryType,num);
    }

    @Override
    public List<Category> findCategoryByTypeAndStatus(Integer type, String status) {
        return categoryMapper.findCategoryByTypeAndStatus(type,status);
    }

    @Override
    public boolean saveCategory(Category category) {
        return categoryMapper.saveCategory(category);
    }

    @Override
    public boolean deleteCategory(Integer id) {
        return categoryMapper.deleteCategory(id);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }
}
