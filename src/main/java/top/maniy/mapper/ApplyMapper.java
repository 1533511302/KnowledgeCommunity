package top.maniy.mapper;

import top.maniy.entity.Apply;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/12/9 14:40
 */
public interface ApplyMapper {

    List<Apply> findApplyByStatus(String status);

    Apply findApplyById(Integer id);

    Apply findApplyByUserId(Integer userId);

    boolean saveApply(Apply apply);

    boolean deleteApply(Integer id);

    boolean updateApply(Apply apply);
}
