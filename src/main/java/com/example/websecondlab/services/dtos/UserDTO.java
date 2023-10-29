package com.example.websecondlab.services.dtos;

public class UserDTO {

    private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private RoleDTO role;
    private String imageUrl;


    public UserDTO(String username, String password, String firstName, String lastName, boolean isActive, RoleDTO role,
                   String imageUrl) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.role = role;
        this.imageUrl = imageUrl;
    }

    public UserDTO() {}


    public long getId() {
        return id;
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

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }

    public RoleDTO getRole() {
        return role;
    }
    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", role=" + role.getRole() +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}