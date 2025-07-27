package com.yash.builder_portfolio_management_springboot.enums;


public enum Role {
    ADMIN(1),
    CONTRACTOR(2),
    CLIENT(3),
    PROJECT_MANAGER(4);

    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Role fromValue(int value) {
        for (Role role : Role.values()) {
            if (role.value == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + value);
    }
}