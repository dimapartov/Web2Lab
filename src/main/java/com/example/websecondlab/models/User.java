package com.example.websecondlab.models;

import java.util.Set;

import com.example.websecondlab.models.base.ImageUrlBaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends ImageUrlBaseEntity {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private Role role;
    private Set<Offer> offers;


    protected User() {}


    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "is_active")
    public boolean isActive() {
        return isActive;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    public Role getRole() {
        return role;
    }

    @OneToMany(mappedBy = "seller", cascade = CascadeType.REMOVE)
    public Set<Offer> getOffers() {
        return offers;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}