package com.mawodu.faceit;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;


public class UserParserTest {

    UserParser userParser;

    @Before
    public void setup() {
        userParser = new UserParser(new ObjectMapper());
    }

    @Test
    public void shouldCorrectlyParseToJSON() {
        Optional<String> userJson = userParser.toJson(getGenericUser());
        Assert.assertTrue(userJson.isPresent());
        Assert.assertEquals(getGenericUserJson(), userJson.get());
    }

    @Test
    public void shouldCorrectlyParseFromJSON() {
        Optional<User> user = userParser.fromJSON(getGenericUserJson());
        User expectedUser = getGenericUser();
        Assert.assertTrue(user.isPresent());
        Assert.assertEquals(expectedUser.getFirstName(), user.get().getFirstName());
        Assert.assertEquals(expectedUser.getLastName(), user.get().getLastName());
        Assert.assertEquals(expectedUser.getNickname(), user.get().getNickname());
    }

    @Test
    @Ignore
    public void shouldHaveTestedThisMoreThoroughly() {
        // FIXME: this feature should have more substantial coverage.
        // outside of scope as prototype only.
        Assert.fail();
    }

    private User getGenericUser() {
        return new User("name", "surname", "nick", "pwd", "em@il.com", "country");
    }

    private String getGenericUserJson() {
        return "{\"firstName\":\"name\",\"lastName\":\"surname\",\"nickname\":\"nick\",\"password\":\"pwd\",\"email\":\"em@il.com\",\"country\":\"country\"}";
    }

}
