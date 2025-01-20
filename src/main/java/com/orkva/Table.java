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

    public Table() {
        tableRows = new ArrayList<>();
        tableFields = new TableField[]{
                new TextTableField(0, "Name", Alignment.RIGHT),
                new HistogramField(1, "Value", 20, Alignment.LEFT)
        };
    }

}
