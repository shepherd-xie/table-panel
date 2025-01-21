package com.orkva.components;

/**
 * @author Shepherd Xie
 * @since 2025/1/20
 */
public class HistogramField extends TableField<Integer> {
    public static final char HISTOGRAM_FILLING = '█';

    protected int scale;

    public HistogramField(int number, String name, int width, Alignment alignment) {
        super(number, name, width, alignment);
    }

    @Override
    public HistogramRowCell createCell(String value) {
        int intVal = Integer.parseInt(value);
        scale = Math.max(scale, intVal);
        return new HistogramRowCell(this, intVal);
    }

}
