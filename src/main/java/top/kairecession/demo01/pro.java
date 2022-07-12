package top.kairecession.demo01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface pro {
    int[] value() default {1, 2};
// value属性可以没有，default关键字设置默认值，也可以不写
    // 但是方法必须有返回值类型，不能是void
    String className() default "none";

    String methodName() default "none";

    String filedName() default "none";
}