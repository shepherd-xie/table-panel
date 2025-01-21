package com.orkva.components;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
public class TextRowCell extends RowCell<String, TextTableField> {

    public TextRowCell(int rowNumber, TextTableField tableField, String value) {
        super(rowNumber, tableField, value);
    }

    @Override
    public String draw() {
        return tableField.alignment.draw(tableField.width, value, FILLING);
    }

}
