package com.mawodu.faceit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.mawodu.faceit.AuditableAction.*;
import static com.mawodu.faceit.AuditableAction.Event.FETCH_ALL_USERS;
import static com.mawodu.faceit.AuditableAction.Event.USER_CREATED;
import static com.mawodu.faceit.AuditableAction.Event.USER_DELETED;


@RestController
public class UserAccessController {

    TransactionsHandler handler;

    @Autowired
    public UserAccessController(TransactionsHandler handler) {
        this.handler = handler;
    }


    @GetMapping(Routes.BASE)
    public String showEndpoints() {
        return new StringBuilder().append("Available endpoints: \n")
                .append(String.join("\n ", Routes.enumerate()))
                .append("\n")
                .toString();
    }

    @AuditableAction(event = USER_CREATED)
    @PostMapping(Routes.ADD_NEW_USER)
    public String createUser(@RequestBody String userJSON) {
        handler.createUser(userJSON);
        // todo: handler should return boolean success/fail
        return "";
    }

    @AuditableAction(event = Event.USER_UPDATED)
    @PostMapping(Routes.EDIT_USER)
    public User editUser(@RequestBody String userJSON) {
        return null;
    }


    // NB. delete requires exact match on all fields (apart from password)
    @AuditableAction(event = USER_DELETED)
    @PostMapping(Routes.DELETE_USER)
    public String deleteUser(@RequestBody String userJSON) {
        handler.createUser(userJSON);
        // todo: handler should return boolean success/fail
        return "";
    }

    @AuditableAction(event = FETCH_ALL_USERS)
    @GetMapping(Routes.FETCH_ALL_USERS)
    public String fetchAllUsers() {
        return handler.fetchAllUsers();
    }

}
