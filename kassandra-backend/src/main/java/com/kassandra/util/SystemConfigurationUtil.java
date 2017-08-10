package com.kassandra.util;

/**
 * @author Onur Karaduman
 * @since 05.08.17
 */
public class SystemConfigurationUtil {

    public static String getVariable(String key) {
        return System.getenv(key);
    }


    public static String getVariable(String key, String defaulVal) {
        String getenv = System.getenv(key);
        return getenv != null ? getenv : defaulVal;
    }
}
