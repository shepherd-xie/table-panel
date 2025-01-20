package com.orkva.components;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
public class TextRowCell extends RowCell<String, TextTableField> {

    public TextRowCell(TextTableField tableTitle, String value) {
        super(tableTitle, value);
    }

    @Override
    public String draw() {
        return tableField.alignment.draw(tableField.width, value, FILLING);
    }

}
