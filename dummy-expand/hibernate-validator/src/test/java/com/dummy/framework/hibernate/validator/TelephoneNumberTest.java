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

package com.github.kanghouchao.framework.hibernate.validator;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.testutil.DummyTraversableResolver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/**
 * @author Lurker
 * @since 06 8月 2020
 */
public class TelephoneNumberTest {

    private Validator validator;

    @Before
    public void setUp() {
        Locale.setDefault(Locale.ENGLISH);
        final Configuration<HibernateValidatorConfiguration> configuration = Validation.byProvider(HibernateValidator.class).configure();
        configuration.traversableResolver(new DummyTraversableResolver());
        this.validator = configuration.buildValidatorFactory().getValidator();
    }

    @Test
    public void testRightNumber() {
        Foo foo = new Foo("18502085804");
        Set<ConstraintViolation<Foo>> violations = validator.validate(foo);
        Assert.assertTrue(violations.isEmpty());
    }

    /**
     * 错误
     */
    @Test
    public void testWrongNumber() {
        Foo foo = new Foo("11111111111");
        Set<ConstraintViolation<Foo>> violations = validator.validate(foo);
        Assert.assertFalse(violations.isEmpty());
        Assert.assertEquals(violations.size(), 1);
        Iterator<ConstraintViolation<Foo>> iterator = violations.iterator();
        ConstraintViolation<Foo> constraintViolation = iterator.next();
        Assert.assertEquals(constraintViolation.getMessage(), "{org.hibernate.validator.constraints.TelephoneNumber.message}");
    }

    private static class Foo {

        @TelephoneNumber
        private final String phoneNumber;

        public Foo(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}
