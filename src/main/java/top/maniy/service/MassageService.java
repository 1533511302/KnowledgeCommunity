package top.maniy.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
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

    List<Massage> findMassageRandTo10();

    //根据标签模糊查询massage
    List<Massage> findMassageLikeLabel(String label);

    //根据时间排序获取massage前5条
    List<Massage> findMassageByCreateTimeDesc0To5();

    //根据点击量排序获取massage前5条
    List<Massage> findMassageByBrowseNumbDesc0To5();

    //根据userId，title模糊查询massage
    PageInfo<Massage> findMassageByUserIdAndLikeTitle(Integer userId,String title, int currentPage, int pageSize);


    //根据userId查询massage
    PageInfo<Massage> findMassageByUserId(Integer userId, int currentPage, int pageSize);

    //根据标题模糊查询
    PageInfo<Massage> findMassageLikeTitle(String title, int currentPage, int pageSize);

    //添加massage
    boolean saveMassage(Massage massage);

    //修改massage
    boolean updateMassage(Massage massage);

    //删除massage
    boolean deleteMassage(Integer id);

}
