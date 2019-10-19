package com.dummy.framework.utils;

import com.dummy.framework.utils.validatation.ValidationError;
import com.dummy.framework.utils.validatation.ValidationResult;
import lombok.experimental.UtilityClass;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/10/02
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
@UtilityClass
public class ValidateUtils {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-]+@[\\w-]+\\.[\\w]+$");

    private static final Pattern ID_CARD_PATTERN = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0-2]\\d)|(3[0-1]))\\d{3}[\\dX]$");

    private static final int[] ID_CARD_WEIGHT = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    private static final char[] ID_CARD_VALIDATE_CODE = new char[]{'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    public static final Pattern MOBILE_PHONE_PATTERN = Pattern.compile("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$");

    public static final Pattern TELEPHONE_PATTERN = Pattern.compile("^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$");

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9][a-zA-Z_0-9.、。@,-]*");

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    public static boolean isEmail(String s) {
        Matcher matcher = EMAIL_PATTERN.matcher(s);
        return matcher.find();
    }

    public static boolean isMobilePhone(String s) {
        Matcher matcher = MOBILE_PHONE_PATTERN.matcher(s);
        return matcher.find();
    }

    public static boolean isTelephone(String s) {
        Matcher matcher = TELEPHONE_PATTERN.matcher(s);
        return matcher.find();
    }

    public static boolean isIDCard(String s) {
        Matcher matcher = ID_CARD_PATTERN.matcher(s);
        if (!matcher.find()) {
            return false;
        } else {
            int sum = 0;

            int mod;
            for (mod = 0; mod < s.length() - 1; ++mod) {
                sum += Integer.parseInt(String.valueOf(s.charAt(mod))) * ID_CARD_WEIGHT[mod];
            }

            mod = sum % 11;
            return s.charAt(s.length() - 1) == ID_CARD_VALIDATE_CODE[mod];
        }
    }

    public static boolean isUsername(String username, Pattern usernamePattern) {
        if (null == username || username.trim().length() == 0) {
            throw new IllegalArgumentException("username must not be empty");
        }
        if (username.contains("\n") || username.contains("\r") || username.contains("\t")) {
            throw new IllegalArgumentException("username must not contain line feed character");
        }
        byte[] usernameByte = username.getBytes();
        if (usernameByte.length < 4 || usernameByte.length > 128) {
            throw new IllegalArgumentException("The length of username must between 4 and 128 bytes. Input is " + username);
        }
        if (!usernamePattern.matcher(username).matches()) {
            throw new IllegalArgumentException("The parameter username contains illegal character," +
                    " a-zA-Z_0-9.、-,@。 is legally, and start with alphabet or number. Input is " + username);
        }
        return true;
    }

    public static boolean isUsername(String username) {
        return isUsername(username, USERNAME_PATTERN);
    }

    public static boolean isPassword(String password) {
        if (null == password || password.trim().length() == 0) {
            throw new IllegalArgumentException("password must not be empty");
        }

        byte[] passwordByte = password.getBytes();
        if (passwordByte.length < 4 || passwordByte.length > 128) {
            throw new IllegalArgumentException("The length of password must between 4 and 128 bytes. Input is " + password);
        }
        return true;
    }

    public static <T> ValidationResult validate(T t) {
        AssertUtils.notNull(t, "参数不能为空");
        final Set<ConstraintViolation<T>> violations = VALIDATOR.validate(t);
        final ValidationResult result = new ValidationResult(violations.size());
        violations.forEach(e -> result.add(new ValidationError(e.getMessage(), e.getPropertyPath().toString(), e.getRootBeanClass(), e.getMessageTemplate())));
        return result;
    }


}
