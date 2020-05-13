package com.mawodu.faceit;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class UserParser {

    private Logger logger = LoggerFactory.getLogger(UserParser.class);
    ObjectMapper objectMapper;

    public UserParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Optional<User> fromJSON(String userJson ) {
        Optional<User> user;

        try {
            user = Optional.of(objectMapper.readValue(userJson, User.class));
            logger.info("successfully parsed JSON into user");

        } catch (IOException e) {
            logger.error(e.getMessage());
            user = Optional.empty();
        }

        return user;
    }

    public Optional<String> toJson(User user) {
        Optional<String> userJson;
        try {

            userJson = Optional.of(objectMapper.writeValueAsString(user));
            logger.info("successfully parsed user into JSON");

        } catch (IOException e) {
            logger.error(e.getMessage());
            userJson = Optional.empty();
        }

        return userJson;
    }

    public Optional<String> toJson(List<User> users) {
        Optional<String> usersJson;
        try {
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            objectMapper.writeValue(out, users);
            usersJson = Optional.of(out.toString());
        } catch (IOException e) {
            logger.error(e.getMessage());
            usersJson = Optional.empty();
        }

        return usersJson;
    }

}
