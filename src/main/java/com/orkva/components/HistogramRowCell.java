package com.orkva.components;

import java.util.Collections;

import static com.orkva.components.HistogramField.HISTOGRAM_FILLING;

/**
 * @author Shepherd Xie
 * @since 2025/1/20
 */
public class HistogramRowCell extends RowCell<Integer, HistogramField> {

    public HistogramRowCell(int rowNumber, HistogramField tableField, Integer value) {
        super(rowNumber, tableField, value);
    }

    @Override
    public String draw() {
        return tableField.alignment.draw(tableField.width, getHistogram(), FILLING);
    }

    public String getHistogram() {
        StringBuilder sb = new StringBuilder();
        Collections.nCopies(value * tableField.width / tableField.scale, HISTOGRAM_FILLING).forEach(sb::append);
        return sb.toString();
    }

}
