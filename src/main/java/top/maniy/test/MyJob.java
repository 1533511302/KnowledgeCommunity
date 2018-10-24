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
            System.out.println("下课了请同学们休息！" + DateUtil.getDateTime());
        }
    }

    public void remindHaveAClass(){
        if(DateUtil.getMiniute()%2!=0) {
            System.out.println("上课了请同学们安静！！！" + DateUtil.getDateTime());
        }
    }

}
