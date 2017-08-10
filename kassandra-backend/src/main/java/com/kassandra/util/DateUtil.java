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
}
