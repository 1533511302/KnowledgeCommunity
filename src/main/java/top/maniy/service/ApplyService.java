package top.maniy.service;

import top.maniy.entity.Apply;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/12/9 19:56
 */
public interface ApplyService {
    List<Apply> findApplyByStatus(String status);

    Apply findApplyByUserId(Integer userId);

    Apply findApplyById(Integer id);

    boolean saveApply(Apply apply);

    boolean deleteApply(Integer id);

    boolean updateApply(Integer id,String status);
}
