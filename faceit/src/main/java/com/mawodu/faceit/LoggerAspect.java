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
        switch(audit.event()) {
            case USER_CREATED:
                logger.info("Call to create new User");
                break;
            case USER_DELETED:
                logger.info("Call to delete User");
                break;
            case USER_UPDATED:
                logger.info("Call to edit User");
                break;
            case FETCH_ALL_USERS:
                logger.info("Call to fetch all users");
                break;

        }
    }

    // fixme: to be implemented for other classes, where logging might be appropriate.
    @After(value = "execution(* com.mawodu.faceit.UserStore.*(..)) && @annotation(audit)")
    public void logStoreActivity(AuditableAction audit) {
        // todo
    }
}
