package com.orkva.components;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
public enum Sort {
    ASC,
    DESC;

    public static Sort parse(String sort) {
        if ("ASC".equals(sort)) {
            return ASC;
        } else if ("DESC".equals(sort)) {
            return DESC;
        }
        throw new IllegalArgumentException("Invalid sort: " + sort);
    }
}
