package com.orkva;

import com.orkva.components.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.*;

/**
 * @author Shepherd Xie
 * @since 2025/1/16
 */
@Slf4j
@Data
public class Table {
    private TableField[] tableFields;
    private List<TableRow> tableRows;
    private Sort sort;
    private String sortField;

    public Table() {
        tableRows = new ArrayList<>();
        tableFields = new TableField[]{
                new TextTableField(0, "Name", Alignment.RIGHT),
                new HistogramField(1, "Value", 20, Alignment.LEFT)
        };
    }

    public void scan(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        int lines = Integer.parseInt(scanner.nextLine());
        String sort = scanner.nextLine();
        String[] sortSplit = sort.split("\\s+");
        this.sortField = sortSplit[0];
        this.sort = Sort.parse(sortSplit[1]);

        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            log.debug("{}", line);
            String[] cells = line.split("\\s+");
            TableRow tableRow = new TableRow(i, new RowCell[tableFields.length]);
            for (int j = 0; j < cells.length; j++) {
                tableRow.rowCells[j] = tableFields[j].createCell(cells[j]);
            }
            tableRows.add(tableRow);
        }
        log.info("{}", tableRows);
    }

}
