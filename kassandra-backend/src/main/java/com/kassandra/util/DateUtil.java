package com.kassandra.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @author Onur Karaduman
 * @since 16.07.17
 */
public class DateUtil {

    public static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static Date oneDayAfter(Date date) {
        DateTime dtOrg = new DateTime(date);
        DateTime dtPlusOne = dtOrg.plusDays(1);
        return dtPlusOne.toDate();
    }


    public static Date stringToDate(String textDate) {
        DateTime dt = DateTime.parse(textDate);
        return dt.toDate();
    }

    public static Date getFirstDayOfMonth(Integer year, Integer month) {
        if (year == null || month == null) {
            throw new IllegalArgumentException("Year and month couldnt be null");
        }
        DateTime dt = new DateTime(year, month, 1, 0, 0, 0, 0);
        return dt.toDate();
    }

    public static Date getNMonthAgo(Integer n) {
        DateTime dt = new DateTime();
        return dt.minusMonths(n).toDate();
    }

    public static Date getNow(){
        DateTime dt = new DateTime();
        return dt.toDate();
    }

    /**
     * Calculate first day of next month and come back 1 day before
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Integer year, Integer month) {
        if (year == null || month == null) {
            throw new IllegalArgumentException("Year and month couldnt be null");
        }
        DateTime dt = new DateTime(year, month + 1, 1, 0, 0, 0, 0).minus(1);
        return dt.toDate();
    }
}
