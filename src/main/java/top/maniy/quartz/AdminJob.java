package top.maniy.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import top.maniy.entity.Apply;
import top.maniy.service.ApplyService;
import top.maniy.util.DateUtil;

/**
 * @author liuzonghua
 * @Package top.maniy.quartz
 * @Description:
 * @date 2018/12/10 13:35
 */
public class AdminJob {

    @Autowired
    private ApplyService applyService;
    public void adminNewContent(){
        if(DateUtil.getMiniute()%30==0) {
            Apply apply =new Apply();
            apply.setContent("一周时间过去了，请管理员处理相关事务。");
            apply.setStatus("3");
            applyService.saveApply(apply);
            System.out.println("一周时间过去了，请管理员处理相关事务。" + DateUtil.getDateTime());
        }
    }
}
