package com.orkva.components;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author Shepherd Xie
 * @since 2025/1/20
 */
@Slf4j
class HistogramFieldTest {

    @Test
    void createCell() {
        HistogramField tableTitle = new HistogramField(1, "Value", 20, Alignment.LEFT);
        log.info("[{}]", tableTitle.createCell("100").draw());
        log.info("[{}]", tableTitle.createCell("51").draw());
        log.info("[{}]", tableTitle.createCell("49").draw());
        log.info("[{}]", tableTitle.createCell("10").draw());
    }
}