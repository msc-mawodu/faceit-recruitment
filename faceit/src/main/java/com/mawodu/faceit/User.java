package com.mawodu.faceit;

public class User {

    private String firstName;
    private String lastName;
    private String nickname;
    private String password; // ...hopefully not plaintext
    private String email;
    private String country;

    public User(String firstName, String lastName, String nickname, String password, String email, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }
}
