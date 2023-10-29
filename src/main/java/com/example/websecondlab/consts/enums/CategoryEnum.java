package com.example.websecondlab.consts.enums;

public enum CategoryEnum {

    CAR(1),
    BUS(2),
    TRUCK(3),
    MOTORCYCLE(4);

    private final int value;

    CategoryEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}