package com.dealership.project.domain.entities.enums;

public enum EngineType {

    ELETRIC(1),
    INTERNAL_COMBUSTION(2),
    HYBRID(3);

    private final int code;

    private EngineType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EngineType valueOf(int code) {
        for (EngineType value : EngineType.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid EngineTipe code");
    }
}
