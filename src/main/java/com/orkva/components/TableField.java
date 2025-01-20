package com.orkva.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
@Data
@AllArgsConstructor
@ToString
public abstract class TableField<T> {

    protected int id;
    protected String name;
    protected int width;
    protected Alignment alignment;

    public abstract RowCell<T, ? extends TableField<T>> createCell(String value);
}
