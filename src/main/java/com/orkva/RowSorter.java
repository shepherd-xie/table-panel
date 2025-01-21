package com.orkva;

import com.orkva.components.Sort;
import com.orkva.components.TableField;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author Shepherd Xie
 * @since 2025/1/20
 */
@Slf4j
@AllArgsConstructor
public class RowSorter {

    private Sort sort;
    private String sortBy;

    public List<TableRow> sort(Table table) {
        TableField sortField = Arrays.stream(table.getTableFields())
                .filter(tableField -> Objects.equals(sortBy, tableField.getName()))
                .findFirst()
                .get();
        TreeMap<Comparable, Integer> sortMap = new TreeMap<>();
        for (TableRow tableRow : table.getTableRows()) {
            sortMap.put(tableRow.rowCells[sortField.getNumber()], tableRow.number);
        }

        List<TableRow> sortedRows = new ArrayList<>();

        sortMap.forEach((k, v) -> {
            sortedRows.add(table.getTableRows().get(v));
        });

        if (sort == Sort.DESC) {
            Collections.reverse(sortedRows);
        }

        return sortedRows;
    }

}
