package com.mawodu.faceit;

import java.util.Arrays;
import java.util.List;

public abstract class Routes {

    public static final String BASE = "/";
    public static final String ACUTATOR_ENDPOINTS = "/actuator/health";
    public static final String ACUTATOR_HEALTH = "/actuator/health";
    public static final String ACUTATOR_INFO = "/actuator/info";

    public static final String FETCH_ALL_USERS = "/fetch-all";
    public static final String ADD_NEW_USER = "/create";
    public static final String EDIT_USER = "/edit";
    public static final String DELETE_USER = "/delete";
    public static final String FETCH_USERS_BY_COUNTRY = "/fetch-by/country/{c}";
    public static final String FETCH_USERS_BY_FORENAME = "/fetch-by/name/{f}";
    public static final String FETCH_USERS_BY_SURNAMENAME = "/fetch-by/name/{s}";
    public static final String FETCH_USERS_BY_NICKNAME = "/fetch-by/name/{s}";
    public static final String FETCH_USERS_BY_EMAIL = "/fetch-by/email/{e}";

    public static List<String> enumerate() {
        return Arrays.asList(
                ACUTATOR_ENDPOINTS, ACUTATOR_HEALTH, ACUTATOR_INFO,
                ADD_NEW_USER, EDIT_USER, DELETE_USER,
                FETCH_ALL_USERS, FETCH_USERS_BY_COUNTRY, FETCH_USERS_BY_EMAIL,
                FETCH_USERS_BY_FORENAME, FETCH_USERS_BY_SURNAMENAME, FETCH_USERS_BY_NICKNAME);
    }
}
