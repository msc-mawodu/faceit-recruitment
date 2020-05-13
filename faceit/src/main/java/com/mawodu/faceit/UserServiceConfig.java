package com.mawodu.faceit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@EnableAspectJAutoProxy
public class UserServiceConfig {

    // fixme: now exposed for rapid prototyping.
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/faceit_user");
        ds.setUsername("faceitapp");
        ds.setPassword("pwd");
        return ds;
    }

    @Bean
    @Autowired
    public JdbcTemplate jdbc(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Autowired
    public UserStore userStore(JdbcTemplate jdbc) {
        return new UserStore(jdbc);
    }
}
