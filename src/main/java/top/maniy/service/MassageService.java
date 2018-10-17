package top.maniy.service;

import com.github.pagehelper.PageInfo;
import top.maniy.entity.Massage;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/10/16 16:25
 */
public interface MassageService {

    //根据id查询massage
    Massage findMassageById(Integer id);

    //根据categoryId分页查询massage
    PageInfo<Massage> findMassageByCategoryId(Integer categoryId, int currentPage, int pageSize);

}
