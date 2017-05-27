package com.staryn.blog.util;

import java.security.MessageDigest;

/**
 * MD5 加密工具类
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-22 16:07:00
 * @see MessageDigest
 */
public abstract class MD5Util {

    /**
     * 获得md5加密结果
     *
     * @param sourceString 原字符串
     * @return 加密结果
     */
    public static String getMD5Str(String sourceString) {
        if (sourceString == null) {
            return null;
        }
        String result;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            result = byteArray2HexStr(md.digest(sourceString.getBytes()));
        } catch (Exception e) {
            LoggerUtil.error("md5_error", "生成md5字符出错！str=" + sourceString);
            throw new RuntimeException("生成md5字符出错！str=" + sourceString);
        }
        return result;
    }

    /**
     * 处理字节数组得到MD5密码的方法
     */
    private static String byteArray2HexStr(byte[] bs) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bs) {
            sb.append(byte2HexStr(b));
        }
        return sb.toString();
    }

    /**
     * 字节标准移位转十六进制方法
     */
    private static String byte2HexStr(byte b) {
        String hexStr;
        int n = b;
        if (n < 0) {
            // 若需要自定义加密,请修改这个移位算法即可
            n = b & 0x7F + 128;
        }
        hexStr = Integer.toHexString(n / 16) + Integer.toHexString(n % 16);
        return hexStr.toUpperCase();
    }
}
