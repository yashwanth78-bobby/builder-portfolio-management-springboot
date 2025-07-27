package com.yash.builder_portfolio_management_springboot.enums;

public enum Role {
    ADMIN,
    CONTRACTOR,
    CLIENT,
    PROJECT_MANAGER;

    public static Role fromString(String roleStr) {
        for (Role role : Role.values()) {
            if (role.name().equalsIgnoreCase(roleStr)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role: " + roleStr);
    }
}
