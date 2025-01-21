package com.orkva;

import java.io.InputStream;

/**
 * @author Shepherd Xie
 * @since 2025/1/20
 */
public class TablePanel {

    private Table table;
    private RowSorter rowSorter;

    public TablePanel(Table table) {
        this.table = table;
    }

    public TablePanel read(InputStream inputStream) {
        InputParser inputParser = new InputParser(inputStream);
        table = inputParser.fullingTable(table);
        rowSorter = inputParser.getRowSorter();
        return this;
    }

    public void draw() {
        TableDrawer tableDrawer = new TableDrawer(table.getTableFields(), rowSorter.sort(table));
        System.out.println(tableDrawer);
    }

}
