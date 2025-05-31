package com.dealership.project.domain.entities.enums;

public enum CustomColor {
    RED(1),
    BLUE(2),
    BLACK(3),
    WHITE(4),
    SILVER(5),
    GOLD(6);

    private final int code;

    private CustomColor(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CustomColor valueOf(int code) {
        for (CustomColor value : CustomColor.values()) {
            if (value.getCode() == code)
                return value;
        }
        throw new IllegalArgumentException("Invalid CustomColor code");
    }
}

