package com.dummy.framework.core.validator;

import com.dummy.framework.utils.ValidateUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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
