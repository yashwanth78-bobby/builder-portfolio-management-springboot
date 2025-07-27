package com.yash.builder_portfolio_management_springboot.enums;


public enum ClientType {
    INDIVIDUAL,
    ORGANIZATION;

    public static ClientType fromString(String typeStr) {
        for (ClientType type : ClientType.values()) {
            if (type.name().equalsIgnoreCase(typeStr)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid client type: " + typeStr);
    }
}

