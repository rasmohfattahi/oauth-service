package com.mft.general.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A marker annotation to be used by BindingResultAspect to make the aspect
 * limited.
 *
 * @author mohsenfattahi81@gmail.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckBindingResult {

}
