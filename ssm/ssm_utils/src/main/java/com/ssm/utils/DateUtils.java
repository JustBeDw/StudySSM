package com.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @date 2020-04-27 17:22
 */
public class DateUtils {

    /**
     * 日期转换成字符串
     * @param date 传入传入要被转换的日期
     * @param patt 日期格式
     * @return 返回字符串类型的日期
     */
    public static String dateToString(Date date,String patt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        return simpleDateFormat.format(date);
    }

    /**
     * 字符串转换成日期
     * @param str 传入要被转换的字符串
     * @param patt 日期格式
     * @return  返回日期类型的日期
     * @throws ParseException
     */
    public static Date stringToDate(String str,String patt) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        return simpleDateFormat.parse(str);
    }


}
