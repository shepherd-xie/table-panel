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
        log.info("{}", tableTitle.createCell("pineapple").draw());
        log.info("{}", tableTitle.createCell("pen").draw());
        log.info("{}", tableTitle.createCell("apple").draw());
    }
}