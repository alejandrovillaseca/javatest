package com.aledev.javatest.utils;

/**
 * DateUtil
 */
public class DateUtil {

    public static boolean isLeapYear(int year){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return true;
        }else{
            return false;
        }
    }
}