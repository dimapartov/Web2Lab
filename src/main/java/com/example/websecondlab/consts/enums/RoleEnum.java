package com.example.websecondlab.consts.enums;

public enum RoleEnum {

    ADMIN(1),
    USER(2);

    private final int value;

    RoleEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}