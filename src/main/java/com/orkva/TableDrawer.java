package com.orkva;

import com.orkva.components.TableField;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Shepherd Xie
 * @since 2025/1/20
 */
public class TableDrawer {
    private StringBuilder drawer;
    private List<TableRow> tableRows;
    private TableField[] tableFields;

    public TableDrawer(TableField[] tableFields, List<TableRow> tableRows) {
        this.tableFields = tableFields;
        this.tableRows = tableRows;
        this.drawer = new StringBuilder();
    }

    @Override
    public String toString() {
        drawChartOutline('┌', '┐', '┬', '─');
        drawer.append('\n');
        drawBody();
        drawChartOutline('└', '┘', '┴', '─');
        return drawer.toString();
    }

    private void drawBody() {
        Iterator<TableRow> iterator = tableRows.iterator();
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
        for (int i = 0; i < tableFields.length; i++) {
            if (i > 0) {
                drawer.append('│');
            }
            drawer.append(row.rowCells[i].draw());
        }
        drawer.append('│').append('\n');
    }

    private void drawChartOutline(char start, char end, char split, char filling) {
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
