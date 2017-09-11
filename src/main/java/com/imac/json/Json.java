package com.imac.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ab054857 on 2017/9/8.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
//@Repeatable(Jsons.class)   // 让方法支持多重@JSON 注解
public @interface Json {
	Class<?> type();
	String include() default "";
	String filter() default "";
}
