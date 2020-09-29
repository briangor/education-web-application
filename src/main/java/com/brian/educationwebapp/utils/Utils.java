package com.brian.educationwebapp.utils;

import java.util.HashMap;

/**
 *
 * @author brian
 */
public class Utils {

    public static String getStringValue_FromHashMap(HashMap hm, String key) {
        String res = null;
        try {
            if (hm.get(key) != null) {
                res = hm.get(key).toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }
}
