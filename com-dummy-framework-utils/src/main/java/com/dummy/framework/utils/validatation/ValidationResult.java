package com.dummy.framework.utils.validatation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/10/02
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
@Getter
@ToString
@AllArgsConstructor
public class ValidationResult {

    private List<ValidationError> errorList;

    public ValidationResult() {
        errorList = Collections.emptyList();
    }

    public ValidationResult(int count) {
        errorList = new ArrayList<>(count);
    }

    public void add(ValidationError validationError) {
        errorList.add(validationError);
    }

}
