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

    //根据标签模糊查询massage
    List<Massage> findMassageLikeLabel(String label);

    //添加massage
    boolean saveMassage(Massage massage);

    //修改massage
    boolean updateMassage(Massage massage);

    //删除massage
    boolean deleteMassage(Integer id);

}
