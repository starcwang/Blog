package com.star.blog.util;

import java.util.Date;

import org.apache.commons.lang.time.FastDateFormat;

/**
 * 日期格式化工具类
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-12 19:20:00
 */
public class DateUtil {

    public static String getAbbreviationMonth(Date date) {
        return FastDateFormat.getInstance("MMM").format(date);
    }
}
