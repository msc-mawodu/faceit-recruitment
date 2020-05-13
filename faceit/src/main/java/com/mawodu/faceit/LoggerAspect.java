package com.mawodu.faceit;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAspect {

    Logger logger = LoggerFactory.getLogger(LoggerAspect.class);


    @Autowired
    public LoggerAspect() {}

    @After(value = "execution(* com.mawodu.faceit.UserAccessController.*(..)) && @annotation(audit)")
    public void logControllerActivity(AuditableAction audit) {
        // todo
    }

    @After(value = "execution(* com.mawodu.faceit.UserStore.*(..)) && @annotation(audit)")
    public void logStoreActivity(AuditableAction audit) {
        // todo
    }
}
