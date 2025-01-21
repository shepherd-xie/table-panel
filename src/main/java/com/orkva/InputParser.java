package com.orkva;

import com.orkva.components.RowCell;
import com.orkva.components.Sort;
import com.orkva.components.TableField;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shepherd Xie
 * @since 2025/1/20
 */
@Slf4j
public class InputParser {
    public static final String SPLITTER = "\\s+";

    private InputStream inputStream;
    private int lines;
    private String sort;
    private String[] rows;


    public InputParser(InputStream inputStream) {
        this.inputStream = inputStream;
        this.parse();
    }

    private void parse() {
        Scanner scanner = new Scanner(inputStream);
        lines = Integer.parseInt(scanner.nextLine());
        sort = scanner.nextLine();

        rows = new String[lines];

        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            log.debug("Read line: {}", line);
            rows[i] = line;
        }
    }

    public RowSorter getRowSorter() {
        String[] sortSplit = sort.split(SPLITTER);
        Sort sort = Sort.parse(sortSplit[1]);
        String sortBy = sortSplit[0];
        return new RowSorter(sort, sortBy);
    }

    public Table fullingTable(Table table) {
        TableField[] tableFields = table.getTableFields();
        List<TableRow> tableRows = table.getTableRows();

        for (int i = 0; i < rows.length; i++) {
            String[] split = rows[i].split(SPLITTER);
            TableRow tableRow = new TableRow(i, new RowCell[tableFields.length]);
            for (TableField tableField : tableFields) {
                tableRow.rowCells[tableField.getNumber()] = tableField.createCell(i, split[tableField.getNumber()]);
            }
            tableRows.add(tableRow);
        }

        return table;
    }

}
