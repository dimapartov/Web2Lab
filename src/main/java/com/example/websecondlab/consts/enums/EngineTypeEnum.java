package com.example.websecondlab.consts.enums;

public enum EngineTypeEnum {

    GASOLINE(1),
    DIESEL(2),
    ELECTRIC(3),
    HYBRID(4);

    private final int value;

    EngineTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}