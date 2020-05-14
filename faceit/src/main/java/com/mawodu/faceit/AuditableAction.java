package com.mawodu.faceit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // this will work only for methods
@Retention(RetentionPolicy.RUNTIME) // make available at runtime for JVM
public @interface AuditableAction {

    Event event();
    String comment() default "";

    enum Event {
        USER_CREATED, USER_UPDATED, USER_READ, USER_DELETED, FETCH_ALL_USERS
    }
}
