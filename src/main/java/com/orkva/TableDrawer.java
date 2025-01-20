package com.orkva;

import com.orkva.components.TableField;

import java.util.Collections;
import java.util.Iterator;

/**
 * @author Shepherd Xie
 * @since 2025/1/20
 */
public class TableDrawer {
    private Table table;
    private StringBuilder drawer;

    public TableDrawer(Table table) {
        this.table = table;
        this.drawer = new StringBuilder();
    }

    public void draw() {
        drawChartOutline('┌', '┐', '┬', '─');
        drawer.append('\n');
        drawBody();
        drawChartOutline('└', '┘', '┴', '─');
        System.out.println(drawer);
    }


    private void drawBody() {
        Iterator<TableRow> iterator = table.getTableRows().iterator();
        while (iterator.hasNext()) {
            drawRowData(iterator.next());

            if (!iterator.hasNext()) {
                continue;
            }

            drawChartOutline('├', '┤', '┼', '─');
            drawer.append('\n');
        }
    }

    private void drawRowData(TableRow row) {
        drawer.append('│');
        for (int i = 0; i < table.getTableFields().length; i++) {
            if (i > 0) {
                drawer.append('│');
            }
            drawer.append(row.rowCells[i].draw());
        }
        drawer.append('│').append('\n');
    }

    private void drawChartOutline(char start, char end, char split, char filling) {
        TableField[] tableFields = table.getTableFields();
        drawer.append(start);
        for (int i = 0; i < tableFields.length; i++) {
            if (i > 0) {
                drawer.append(split);
            }
            Collections.nCopies(tableFields[i].getWidth(), filling).forEach(drawer::append);
        }
        drawer.append(end);
    }
}
