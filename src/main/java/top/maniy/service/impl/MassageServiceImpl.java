package top.maniy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Massage;
import top.maniy.mapper.MassageMapper;
import top.maniy.service.MassageService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/10/16 16:28
 */
@Service
public class MassageServiceImpl implements MassageService {

    @Autowired
    private MassageMapper massageMapper;

    @Override
    public Massage findMassageById(Integer id) {
        return massageMapper.findMassageById(id);
    }

    @Override
    public PageInfo<Massage> findMassageByCategoryId(Integer categoryId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Massage> massageList =massageMapper.findMassageByCategoryId(categoryId);
        PageInfo<Massage> pageInfo = new PageInfo<Massage>(massageList);
        return pageInfo;
    }

    @Override
    public List<Massage> findMassageRandTo10() {
        return massageMapper.findMassageRand(10);
    }

    @Override
    public List<Massage> findMassageLikeLabel(String label) {
        return null;
    }

    @Override
    public List<Massage> findMassageByCreateTimeDesc0To5() {
        return massageMapper.findMassageByCreateTimeDesc(0,5);
    }

    @Override
    public List<Massage> findMassageByBrowseNumbDesc0To5() {
        return massageMapper.findMassageByBrowseNumbDesc(0,5);
    }

    @Override
    public PageInfo<Massage> findMassageByUserIdAndLikeTitle(Integer userId, String title, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Massage> massageList =massageMapper.findMassageByUserIdAndLikeTitle(userId,title);
        PageInfo<Massage> pageInfo = new PageInfo<Massage>(massageList);
        return pageInfo;
    }

    @Override
    public PageInfo<Massage> findMassageByUserId(Integer userId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Massage> massageList =massageMapper.findMassageByUserId(userId);
        PageInfo<Massage> pageInfo = new PageInfo<Massage>(massageList);
        return pageInfo;
    }

    @Override
    public PageInfo<Massage> findMassageLikeTitle(String title, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Massage> massageList =massageMapper.findMassageLikeTitle(title);
        PageInfo<Massage> pageInfo = new PageInfo<Massage>(massageList);
        return pageInfo;
    }

    @Override
    public boolean saveMassage(Massage massage) {
        return massageMapper.saveMassage(massage);
    }

    @Override
    public boolean updateMassage(Massage massage) {
        return false;
    }

    @Override
    public boolean deleteMassage(Integer id) {
        return false;
    }
}
