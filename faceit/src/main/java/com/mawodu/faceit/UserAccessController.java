package com.mawodu.faceit;


import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
public class UserAccessController {

    @GetMapping(Routes.BASE)
    public String showEndpoints() {
        return new StringBuilder().append("Available endpoints: \n")
                .append(String.join("\n ", Routes.enumerate()))
                .append("\n")
                .toString();
    }

    @PostMapping(Routes.ADD_NEW_USER)
    public User createUser(@RequestBody Map<String, Object> userJSON) {
        return null;
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
