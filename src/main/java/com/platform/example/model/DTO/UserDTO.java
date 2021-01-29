package com.platform.example.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String last_name;
    private String first_name;
    private String email;
    private String phone_number;
    private Boolean is_admin;

    public UserDTO() {
    }

    public UserDTO(@JsonProperty("id") Long id,
                   @JsonProperty("username") String userName,
                   @JsonProperty("password") String password,
                   @JsonProperty("last_name") String lastName,
                   @JsonProperty("first_name") String firstName,
                   @JsonProperty("email") String email,
                   @JsonProperty("phone_number") String phoneNumber,
                   @JsonProperty("is_admin") Boolean isAdmin) {

        this.id = id;
        this.username = userName;
        this.password = password;
        this.last_name = lastName;
        this.first_name = firstName;
        this.email = email;
        this.phone_number = phoneNumber;
        this.is_admin = isAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", is_admin=" + is_admin +
                '}';
    }
}
