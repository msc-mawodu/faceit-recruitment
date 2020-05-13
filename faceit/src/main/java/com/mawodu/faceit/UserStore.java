package com.mawodu.faceit;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class UserStore {

    public static final String USER_TABLE_NAME = "faceit_user.user";
    private JdbcTemplate jdbc;

    public UserStore(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(User user) {
        // jdbc update uses prepared statement, so basic injection prevention is satisfied.
        jdbc.update("insert into " + USER_TABLE_NAME +
                        " (forename, surname, nickname, password, email, country)" +
                        " values (?, ?, ?, ?, ?, ?)",
                user.getFirstName(),
                user.getLastName(),
                user.getNickname(),
                user.getPassword(),
                user.getEmail(),
                user.getCountry()
        );
    }

    public void delete(User user) {
        // jdbc update uses prepared statement, so basic injection prevention is satisfied.
        jdbc.update(" delete from " + USER_TABLE_NAME +
                        " where forename=? AND surname=? AND nickname=? AND email=?",
                user.getFirstName(),
                user.getLastName(),
                user.getNickname(),
                user.getEmail()
        );
    }

    public boolean userExists(User user) {
        return jdbc.queryForObject("SELECT count(*) FROM " + USER_TABLE_NAME +
                        " where forename=? AND surname=? AND nickname=? AND email=?", Integer.class,
                user.getFirstName(),
                user.getLastName(),
                user.getNickname(),
                user.getEmail()) > 0;
    }

    public List<String> fetchUsers() {
        List<String> users = new ArrayList<>();
        jdbc.query("SELECT DISTINCT nickname FROM " + USER_TABLE_NAME, result -> {
            users.add(result.getString(1));
        });

        return users;
    }

}
