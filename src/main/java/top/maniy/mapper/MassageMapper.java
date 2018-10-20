package top.maniy.mapper;

import org.apache.ibatis.annotations.Param;
import top.maniy.entity.Massage;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/16 15:33
 */
public interface MassageMapper {
    //根据类型查询massage集合
    List<Massage> findMassageByCategoryId(Integer categoryId);

    //根据id查询massage
    Massage findMassageById(Integer id);

    //根据标签模糊查询massage
    List<Massage> findMassageLikeLabel(@Param("label") String label);

    //根据标题模糊查询
    List<Massage> findMassageLikeTitle(@Param("title") String title);
    //添加massage
    boolean saveMassage(Massage massage);

    //修改massage
    boolean updateMassage(Massage massage);

    //删除massage
    boolean deleteMassage(Integer id);

}
