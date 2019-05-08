package org.whale.common;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @ClassName： AuthLogin
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月29日
*/
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
@Documented
public @interface AuthLogin {}

