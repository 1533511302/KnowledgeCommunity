package top.maniy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Apply;
import top.maniy.mapper.ApplyMapper;
import top.maniy.service.ApplyService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/12/9 19:59
 */
@Service
public class ApplyServiceImpl implements ApplyService{

    @Autowired
    private ApplyMapper applyMapper;

    @Override
    public List<Apply> findApplyByStatus(String status) {
        return applyMapper.findApplyByStatus(status);
    }

    @Override
    public Apply findApplyByUserId(Integer userId) {
        return applyMapper.findApplyByUserId(userId);
    }

    @Override
    public Apply findApplyById(Integer id) {
        return applyMapper.findApplyById(id);
    }

    @Override
    public boolean saveApply(Apply apply) {
        return applyMapper.saveApply(apply);
    }

    @Override
    public boolean deleteApply(Integer id) {
        return applyMapper.deleteApply(id);
    }

    @Override
    public boolean updateApply(Integer id,String status) {
        Apply apply =new Apply();
        apply.setId(id);
        apply.setStatus(status);
        return applyMapper.updateApply(apply);
    }
}
