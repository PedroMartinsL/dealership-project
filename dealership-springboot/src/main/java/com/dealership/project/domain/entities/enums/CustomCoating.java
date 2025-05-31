package com.dealership.project.domain.entities.enums;

public enum CustomCoating {
    MATTE(1),
    GLOSSY(2),
    SATIN(3),
    TEXTURED(4);

    private final int code;

    private CustomCoating(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CustomCoating valueOf(int code) {
        for (CustomCoating value : CustomCoating.values()) {
            if (value.getCode() == code)
                return value;
        }
        throw new IllegalArgumentException("Invalid CustomCoating code");
    }
}
