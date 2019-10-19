package com.dummy.framework.core.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/10/02
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {PhoneNumberValidator.class})
public @interface PhoneNumber {

    boolean required() default true;

    String message() default "手机号码格式有误!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
