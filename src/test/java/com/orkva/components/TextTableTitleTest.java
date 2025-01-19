package com.orkva.components;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
@Slf4j
class TextTableTitleTest {

    @Test
    void createCell() {
        TextTableTitle textTableTitle = new TextTableTitle("Name", Alignment.LEFT);
        TableCell<?, ?> pineapple = textTableTitle.createCell("pineapple");
        log.info("{}", pineapple);
    }
}