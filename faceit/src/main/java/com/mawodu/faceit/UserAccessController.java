package com.mawodu.faceit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
public class UserAccessController {

    private UserStore userStore;

    @Autowired
    public UserAccessController(UserStore userStore) {
        this.userStore = userStore;
    }

    @GetMapping(Routes.BASE)
    public String showEndpoints() {
        return new StringBuilder().append("Available endpoints: \n")
                .append(String.join("\n ", Routes.enumerate()))
                .append("\n")
                .toString();
    }

    @PostMapping(Routes.ADD_NEW_USER)
    public String createUser(@RequestBody Map<String, Object> userJSON) {
        return "ok";
    }


    @PostMapping(Routes.EDIT_USER)
    public User editUser(@RequestBody Map<String, Object> userJSON) {
        return null;
    }


    // NB. delete requires exact match on all fields (apart from password)
    @PostMapping(Routes.DELETE_USER)
    public User deleteUser(@RequestBody Map<String, Object> userJSON) {
        return null;
    }


    @PostMapping(Routes.FETCH_ALL_USERS)
    public User fetchAllUsers() {
        return null;
    }

}
