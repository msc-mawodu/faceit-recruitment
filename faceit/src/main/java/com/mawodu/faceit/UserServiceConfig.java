package com.mawodu.faceit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
@EnableAspectJAutoProxy
public class UserServiceConfig {

    @Bean
    @Autowired
    public UserStore userStore(DataSource dataSource) {
        return new UserStore(new JdbcTemplate(dataSource));
    }
}
