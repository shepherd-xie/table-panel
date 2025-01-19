package com.orkva.components;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
public class TextTableCell extends TableCell<String, TextTableTitle> {

    public TextTableCell(TextTableTitle tableTitle, String value) {
        super(tableTitle, value);
    }

    @Override
    public String draw() {
        return tableTitle.alignment.draw(tableTitle.width, drawValue(), FILLING);
    }

    @Override
    public String drawValue() {
        return value;
    }
}
