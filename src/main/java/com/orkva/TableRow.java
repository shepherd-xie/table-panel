package com.orkva;

import com.orkva.components.RowCell;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Shepherd Xie
 * @since 2025/1/16
 */
@Data
@AllArgsConstructor
public class TableRow {

    int number;
    RowCell[] rowCells;

}
