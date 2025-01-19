package com.orkva.components;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
public class TextTableTitle extends TableTitle<String> {

    public TextTableTitle(String name, Alignment alignment) {
        super(name, 0, alignment);
    }


    @Override
    public TableCell<String, ? extends TableTitle<String>> createCell(String value) {
        width = Math.max(width, value.length());
        return new TextTableCell(this, value);
    }
}
