package com.orkva;

import com.orkva.components.Alignment;
import com.orkva.components.HistogramField;
import com.orkva.components.TextTableField;

/**
 * @author Shepherd Xie
 * @since 2025/1/16
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table(
                new TextTableField(0, "Name", Alignment.RIGHT),
                new HistogramField(1, "Value", 20, Alignment.LEFT)
        );
        new TablePanel(table)
                .read(System.in)
                .draw();
    }
}