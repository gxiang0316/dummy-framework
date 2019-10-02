package com.dummy.framework.utils.validatation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationError {

    private String message;

    private String propertyPath;

    private Class<?> rootBeanClass;

    private String messageTemplate;
    
}
