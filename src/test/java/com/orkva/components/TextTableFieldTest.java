package com.orkva.components;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
@Slf4j
class TextTableFieldTest {

    @Test
    void createCell() {
        TextTableField tableTitle = new TextTableField(0, "Name", Alignment.RIGHT);
        log.info("{}", tableTitle.createCell(0, "pineapple").draw());
        log.info("{}", tableTitle.createCell(1, "pen").draw());
        log.info("{}", tableTitle.createCell(2, "apple").draw());
    }
}