package com.orkva.components;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
@AllArgsConstructor
@ToString
public abstract class RowCell<T, U extends TableField<T>> {
    public static final char FILLING = ' ';

    protected U tableField;
    protected T value;

    public abstract String draw();

}
