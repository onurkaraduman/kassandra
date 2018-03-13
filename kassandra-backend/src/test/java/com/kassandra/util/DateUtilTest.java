package com.kassandra.util;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void oneDayAfter() {
    }

    @Test
    public void stringToDate() {
    }

    @Test
    public void getFirstDayOfMonth() {
    }

    @Test
    public void getNMonthAgo() {
    }

    @Test
    public void getNow() {
    }

    @Test
    public void getLastDayOfMonth() {
    }

    @Test
    public void compareDateOnly() {
        Date d1 = new Date();
        Date d2 = new Date();
        int i = DateUtil.compareDateOnly(d1, d2);
        assertEquals(i, 0);


        d1 = new Date();
        d2 = DateUtil.oneDayAfter(d1);
        i = DateUtil.compareDateOnly(d1, d2);
        assertEquals(i, -1);
    }
}