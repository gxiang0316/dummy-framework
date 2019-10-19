package com.dummy.framework.core.validator;

import com.dummy.framework.utils.ValidateUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/10/02
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private boolean require = false;

    @Override
    public void initialize(PhoneNumber isMobile) {
        require = isMobile.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (require) {
            return ValidateUtils.isMobilePhone(value);
        } else {
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {
                return ValidateUtils.isMobilePhone(value);
            }
        }
    }
}
