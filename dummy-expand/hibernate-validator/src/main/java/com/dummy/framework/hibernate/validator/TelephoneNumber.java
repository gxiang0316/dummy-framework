/*
 * Copyright 2019 kanghouchao
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dummy.framework.hibernate.validator;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 电话号码
 *
 * @author Lurker
 * @since 06 8月 2020
 */
@Documented
@Constraint(validatedBy = {})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(TelephoneNumber.List.class)
@ReportAsSingleViolation
@Pattern(regexp = "")
public @interface TelephoneNumber {

    String message() default "{org.hibernate.validator.constraints.TelephoneNumber.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * @return an additional regular expression the annotated string must match. The default is any string ('[1]([3-9])[0-9]{9}')
     */
    @OverridesAttribute(constraint = Pattern.class, name = "regexp") String regexp() default "[1]([3-9])[0-9]{9}";

    /**
     * @return used in combination with {@link #regexp()} in order to specify a regular expression option
     */
    @OverridesAttribute(constraint = Pattern.class, name = "flags") Pattern.Flag[] flags() default {};

    /**
     * Defines several {@code @TelephoneNumber} annotations on the same element.
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        TelephoneNumber[] value();
    }

}
