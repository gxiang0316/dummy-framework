package com.dummy.framework.utils;

import lombok.experimental.UtilityClass;
import org.springframework.util.Assert;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/10/02
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
@UtilityClass
public class AssertUtils {

    public static void isNull(Object obj, String message) {
        Assert.isNull(obj, message);
    }

    public static void notNull(Object obj, String message) {
        Assert.notNull(obj, message);
    }


    public static void isTrue(boolean b, RuntimeException e) {
        if (!b) {
            throw e;
        }
    }
}
