package com.orkva;

import com.orkva.components.Sort;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Shepherd Xie
 * @since 2025/1/20
 */
@AllArgsConstructor
public class RowSorter {

    private Sort sort;
    private String sortBy;

    public List<TableRow> sort(List<TableRow> tableRows) {
        return tableRows;
    }

}
