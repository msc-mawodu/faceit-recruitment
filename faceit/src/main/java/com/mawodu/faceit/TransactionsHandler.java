package com.mawodu.faceit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


// intermediate service wrapper between data access and controller

@Service
public class TransactionsHandler {

    private UserStore store;
    private UserParser parser;

    @Autowired
    public TransactionsHandler(UserStore store, UserParser parser) {
        this.store = store;
        this.parser = parser;
    }

    public void createUser(String userJson) {
        parser.fromJSON(userJson)
                .ifPresent(store::save);
    }

    public void deleteUser(String userJson) {
        parser.fromJSON(userJson)
                .ifPresent(store::delete);
    }

    public String fetchAllUsers() {
        return parser.toJson(store.fetchUsers()).orElse("");
    }


}
