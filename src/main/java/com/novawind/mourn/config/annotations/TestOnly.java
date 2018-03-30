package com.novawind.mourn.config.annotations;

import java.lang.annotation.*;

/**
 * Only indicates that the method or field is only available for testing.
 * @author Jeremy Xiong<br>
 * 2018-02-07 16:10
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.FIELD})
@Documented
@Inherited
public @interface TestOnly {
}
