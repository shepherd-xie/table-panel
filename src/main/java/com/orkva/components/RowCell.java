package com.orkva.components;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Objects;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
@AllArgsConstructor
@ToString
public abstract class RowCell<T extends Comparable<T>, U extends TableField<T>>
        implements Comparable<RowCell<T, U>> {
    public static final char FILLING = ' ';

    protected U tableField;
    protected T value;

    public abstract String draw();

    @Override
    public int compareTo(RowCell<T, U> o) {
        if (!Objects.equals(tableField, o.tableField)) {
            throw new IllegalArgumentException("Another table field.");
        }
        return value.compareTo(o.value);
    }
}
