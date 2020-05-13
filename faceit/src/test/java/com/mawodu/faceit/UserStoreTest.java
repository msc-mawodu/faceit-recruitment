package com.mawodu.faceit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;


// Run only manually, as does changes to the DB.
@RunWith(SpringJUnit4ClassRunner.class)
public class UserStoreTest {

    private UserStore store;

    @Before
    public void setup() {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource());
        store = new UserStore(jdbc);
    }

    @Test
    public void shouldStoreAndDeleteNewUserCorrectly() {
        User user = getGenericUser();
        store.save(user);
        Assert.assertTrue(store.userExists(user));
        store.delete(getGenericUser());
        Assert.assertFalse(store.userExists(user));
    }

    @Test
    public void shouldCorrectlyFetch() {
        // todo: implement further tests, to fully cover CRUD actions.
    }

    private User getGenericUser() {
        return new User("name", "surname", "nick", "pwd", "em@il.com", "country");
    }

    // FIXME: this simplified config if for prototyping purposed only.
    private DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/faceit_user");
        ds.setUsername("faceitapp");
        ds.setPassword("pwd");
        return ds;
    }

}
