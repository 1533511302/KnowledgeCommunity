package top.maniy.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.entity.Apply;
import top.maniy.entity.User;
import top.maniy.service.ApplyService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/12/9 20:10
 */
@Controller
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    @RequestMapping("saveApply")
    @ResponseBody
    @RequiresPermissions("apply:insert")
    public String saveApply(Integer userId, HttpServletRequest request){
        Apply temp =applyService.findApplyByUserId(userId);
        User user = (User) request.getSession().getAttribute("User");
        if (user!=null){
            if(user.getAutograph()=="" || user.getIntroduce()=="" || user.getRealname()==""){
                return "3";
            }
        }
        if(temp==null){
            Apply apply =new Apply();
            apply.setUserId(userId);
            apply.setContent("编号为："+userId+"的用户—申请成为认证用户");
             applyService.saveApply(apply);
            return "1";
        }
       return "2";
    }

    @RequestMapping("findApplyByStatus")
    @ResponseBody
    @RequiresPermissions("all:all")
    public List<Apply> findApplyByStatus(){
        return applyService.findApplyByStatus("1");
    }

    @RequestMapping("updateApply")
    @ResponseBody
    @RequiresPermissions("apply:update")
    public boolean updateApply(Integer id){
        return applyService.updateApply(id,"2");
    }


    @RequestMapping("deleteApply")
    @ResponseBody
    @RequiresPermissions("apply:delete")
    public boolean deleteApply(Integer id){
        return applyService.deleteApply(id);
    }

}
