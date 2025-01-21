package com.orkva;

import com.orkva.components.Alignment;
import com.orkva.components.HistogramField;
import com.orkva.components.TextTableField;
import org.junit.jupiter.api.Test;

/**
 * @author Shepherd Xie
 * @since 2025/1/20
 */
class TablePanelTest {

    @Test
    void draw() {
        Table table = new Table(
                new TextTableField(0, "Name", Alignment.RIGHT),
                new HistogramField(1, "Value", 20, Alignment.LEFT)
        );
        new TablePanel(table)
                .read(ClassLoader.getSystemResourceAsStream("testcase.txt"))
                .draw();
    }

    @Test
    void draw5Rows() {
        Table table = new Table(
                new TextTableField(0, "Name", Alignment.RIGHT),
                new HistogramField(1, "Value", 20, Alignment.LEFT)
        );
        new TablePanel(table)
                .read(ClassLoader.getSystemResourceAsStream("testcase_5_rows.txt"))
                .draw();
    }

    @Test
    void drawOtherFields() {
        Table table = new Table(
                new TextTableField(0, "Name", Alignment.RIGHT),
                new HistogramField(1, "Value", 20, Alignment.LEFT),
                new TextTableField(2, "Color", Alignment.CENTER)
        );
        new TablePanel(table)
                .read(ClassLoader.getSystemResourceAsStream("testcase_other_fields.txt"))
                .draw();
    }
}