package com.aoying.loan.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;
import java.util.List;

/**
 * @描述:其它工具类
 * @项目名:bdfenqi
 * @author:hezitai@zealfi.com
 * @日期:2018/9/3
 */
public class OtherTool {
    /**
     * list深克隆
     * @param src
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> deepCopyList(List<T> src)
    {
        List<T> dest = null;
        try
        {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            dest = (List<T>) in.readObject();
        }
        catch (IOException e){}
        catch (ClassNotFoundException e){}
        return dest;
    }

    /**
     * 计算两个日期之间相差的天数
     * @param day1
     * @param day2
     * @return
     */
    public static Integer getDays(Timestamp day1, Timestamp day2){
        /*天数差*/
        long to1 = day1.getTime();
        long from1 = day2.getTime();
        Integer days = (int) (Math.abs(to1 - from1) / (1000 * 60 * 60 * 24));
        return days;
    }
    /**
     * 计算两个日期之间相差的小时
     * @param day1
     * @param day2
     * @return
     */
    public static Integer getHours(Timestamp day1, Timestamp day2){
        /*小时差*/
        long from2 = day1.getTime();
        long to2 = day2.getTime();
        Integer hours = (int) (Math.abs(to2 - from2) / (1000 * 60 * 60));
        return hours;
    }
    /**
     * 计算两个日期之间相差的分钟
     * @param day1
     * @param day2
     * @return
     */
    public static Integer getMinutes(Timestamp day1, Timestamp day2){
        /*分钟差*/
        long from3 = day1.getTime();
        long to3 = day2.getTime();
        Integer minutes = (int) (Math.abs(to3 - from3) / (1000 * 60));
        return minutes;
    }

}
