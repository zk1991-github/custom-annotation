package com.github.zk.customannotation.annotation;

import java.lang.annotation.*;

/**
 * @author zhaokai
 * @date 2019/4/7 下午3:09
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    String name() default "";

}
