package com.dealership.project.domain.entities.enums;

public enum CustomWheel {
    STANDARD(1),
    SPORT(2),
    OFFROAD(3),
    PERFORMANCE(4);

    private int code;

    private CustomWheel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CustomWheel valueOf(int code) {
        for (CustomWheel value : CustomWheel.values()) {
            if (value.getCode() == code)
                return value;
        }
        throw new IllegalArgumentException("Invalid CustomWheel code");
    }
}

