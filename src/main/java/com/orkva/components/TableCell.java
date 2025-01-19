package com.orkva.components;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
@AllArgsConstructor
@ToString
public abstract class TableCell<T, U extends TableTitle<T>> {
    public static final char FILLING = ' ';

    protected U tableTitle;
    protected T value;

    public abstract String draw();

    public abstract String drawValue();
}
