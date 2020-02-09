package cn.js.today.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since
 * @UpdateUser: liuping
 * @UpdateDate:
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class DateUtils {

    /**
     * 获取今天之前的七天的日期
     * @return
     */
    public static  String [] getBeforeSevenDay(){
        String [] arr = new String[7];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = null;
        for (int i=0;i<7;i++){
            c= Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, - i-1);
            arr[6-i] =sdf.format(c.getTime());

        }
        return arr;
    }

    /**
     * 获取过去7天内的日期数组
     * @param intervals      intervals天内
     * @return              日期数组
     */
    public static ArrayList<String> getDays(int intervals) {
        ArrayList<String> pastDaysList = new ArrayList<>();
        for (int i = intervals -1; i >= 0; i--) {
            pastDaysList.add(getPastDate(i));
        }
        return pastDaysList;
    }

    /**
     * 获取过去第几天的日期
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }


    /**
     *  获取最近七天的日期，包括当天的日期
     * @return
     */
    public static  String [] getBeforeIncludeSevenDay(){
        String [] arr = new String[7];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = null;
        for (int i=1;i<=7;i++){
            c= Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, - i-1);
            arr[6-i] =sdf.format(c.getTime());

        }
        return arr;
    }

    public static void main(String[] args) {

//        String [] arr=getBeforeSevenDay();
//
//        for (int i = 0; i < arr.length; i++) {
//
//            System.err.println(arr[i]);
//        }

        //获取最近七天的日期，包括当天的日期
        ArrayList<String> arrayList = getDays(7);
        System.err.println(arrayList.toString());

    }

}
