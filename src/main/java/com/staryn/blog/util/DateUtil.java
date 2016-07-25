package com.staryn.blog.util;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;

/**
 * 日期格式化工具类
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-12 19:20:00
 */
public abstract class DateUtil {

    private static final String DATE_TIME_STR = "yyyy-MM-dd HH:mm:ss";
    private static final FastDateFormat DATE_TIME_FORMAT = FastDateFormat.getInstance(DATE_TIME_STR);

    /**
     * 各种日期格式
     */
    private static final String[] DATE_PATTERNS = {"yyyy-MM-dd", "yyyyMMdd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss",
            "yyyyMMddHHmmss"};

    /**
     * 格式化日期时间，输出格式：yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期
     * @return "yyyy-MM-dd HH:mm:ss"
     */
    public static String formatToStr(Date date) {
        if (date == null) {
            return null;
        }
        return DATE_TIME_FORMAT.format(date);
    }

    /**
     * 解析日期，支持格式
     *
     * @param str 日期串
     * @return {@link java.util.Date}
     * @see #DATE_PATTERNS
     */
    public static Date parse(String str) {
        Date date;
        try {
            date = DateUtils.parseDate(str, DATE_PATTERNS);
        } catch (Exception e) {
            LoggerUtil.error("DateUtil_error", "日期解析出错。输入：" + str + ", 支持格式：" + JsonUtil.toJson(DATE_PATTERNS));
            throw new RuntimeException("日期解析出错!", e);
        }
        return date;
    }

    /**
     * 格式化日期时间，输出格式：自定义
     *
     * @param date    日期
     * @param pattern 格式
     * @return 自定义格式
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 字符串日期格式转换，自定义格式
     *
     * @param datetime 日期字符串
     * @param pattern  欲转成的日期字符串
     * @return 自定义格式
     */
    public static String format(String datetime, String pattern) {
        return format(parse(datetime), pattern);
    }
}
