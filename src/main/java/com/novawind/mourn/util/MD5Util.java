package com.novawind.mourn.util;

import java.security.MessageDigest;

/**
 * @author Jeremy Xiong<br>
 * 2017-12-21 09:47
 */
public class MD5Util {
    /**
     * 加密(MD5)
     * @param s to be encryped
     * @return 返回加密字串（小写）
     */
    public static String md5Lower(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

        if (null == s || "".equals(s))
            return "";

        try {
            byte[] strtemp = s.getBytes();
            MessageDigest mdtemp = MessageDigest.getInstance("MD5");
            mdtemp.update(strtemp);
            byte[] md = mdtemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * MD5加密
     * @param s to be encryped
     * @return 返回加密字串（大写）
     */
    public static String md5Upper(String s){
        String lower = md5Lower(s);
        return lower != null ? lower.toUpperCase() : null;
    }

    public static String salt(int codesLength){
        String raw = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] codes = raw.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codesLength; i++) {
            sb.append(codes[(int)(36 * Math.random())]);
        }

        return sb.toString();
    }


    public static void main (String[] args) {
        String s = salt(8);
        System.out.println(s);
        System.out.println(md5Upper("111" + s));
    }
}
