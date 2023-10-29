package com.example.websecondlab.services.dtos;

import com.example.websecondlab.consts.enums.RoleEnum;

public class RoleDTO {

    private long id;
    private RoleEnum role;


    public RoleDTO(RoleEnum role) {
        this.role = role;
    }

    public RoleDTO() {}


    public long getId() {
        return id;
    }

    public RoleEnum getRole() {
        return role;
    }
    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}