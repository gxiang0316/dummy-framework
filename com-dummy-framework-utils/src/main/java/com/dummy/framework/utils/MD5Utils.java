package com.dummy.framework.utils;

import lombok.experimental.UtilityClass;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@UtilityClass
public class MD5Utils {

    private static final String MD5 = "MD5";

    public static String encode(String text) {
        final StringBuilder builder = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            md.update(text.getBytes());
            byte[] b = md.digest();
            int i;
            for (byte value : b) {
                i = value;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    builder.append("0");
                builder.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
