package top.maniy.test;

import top.maniy.util.DateUtil;

/**
 * @author liuzonghua
 * @Package top.maniy.test
 * @Description:
 * @date 2018/10/22 17:08
 */
public class MyJob {

    public void remindClassIsOver(){
        if(DateUtil.getMiniute()%2==0) {
            System.out.println("时间过去了两分钟" + DateUtil.getDateTime());
        }
    }

    public void remindHaveAClass(){
        if(DateUtil.getMiniute()%2!=0) {
            System.out.println("项目又运行了一两分钟！" + DateUtil.getDateTime());
        }
    }

}
