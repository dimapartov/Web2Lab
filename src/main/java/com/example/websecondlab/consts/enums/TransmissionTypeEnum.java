package com.example.websecondlab.consts.enums;

public enum TransmissionTypeEnum {

    MANUAL(1),
    AUTOMATIC(2);

    private final int value;

    TransmissionTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}