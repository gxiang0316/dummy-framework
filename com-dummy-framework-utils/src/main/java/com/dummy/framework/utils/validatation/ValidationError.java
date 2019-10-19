package com.dummy.framework.utils.validatation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lurker
 * <p>
 * 日期： 2019/10/02
 * 联系方式: hchkang8710@gmail.com
 * <p/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationError {

    private String message;

    private String propertyPath;

    private Class<?> rootBeanClass;

    private String messageTemplate;
    
}
