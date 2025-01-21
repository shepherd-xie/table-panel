package com.orkva.components;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
public class TextTableField extends TableField<String> {

    public TextTableField(int number, String name, Alignment alignment) {
        super(number, name, 0, alignment);
    }


    @Override
    public TextRowCell createCell(String value) {
        width = Math.max(width, value.length());
        return new TextRowCell(this, value);
    }

}
