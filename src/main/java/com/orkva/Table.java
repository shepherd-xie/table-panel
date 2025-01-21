package com.orkva;

import com.orkva.components.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

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

    public Table(TableField... tableFields) {
        this.tableFields = tableFields;
        tableRows = new ArrayList<>();
    }

}
