package com.yash.builder_portfolio_management_springboot.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Role role) {
        return role != null ? role.getValue() : null;
    }

    @Override
    public Role convertToEntityAttribute(Integer value) {
        return value != null ? Role.fromValue(value) : null;
    }
}