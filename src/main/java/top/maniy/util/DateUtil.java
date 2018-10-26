package top.maniy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {



    public static String DateTimeToString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式

        String time=df.format(date);//顾客预定时的系统时间
        return time;
    }

    /**
     * 自定义日期格式
     * @return
     */
    public static String getDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date=new Date();// new Date()为获取当前系统时间
        String time=df.format(date);//顾客预定时的系统时间
        return time;
    }



    public static String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Date date=new Date();// new Date()为获取当前系统时间
        String time=df.format(date);//顾客预定时的系统时间
        return time;
    }

    public static int getMiniute(){
        SimpleDateFormat df = new SimpleDateFormat("mm");//设置日期格式
        Date date=new Date();// new Date()为获取当前系统时间
        String time=df.format(date);//顾客预定时的系统时间
        return Integer.valueOf(time);
    }
//    public static String cleanZero(){
//
//    }

    public static void main(String s[]){
        System.out.println(DateUtil.getMiniute());
    }

}
