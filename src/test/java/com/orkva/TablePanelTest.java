package com.orkva;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;

/**
 * @author Shepherd Xie
 * @since 2025/1/16
 */
class TablePanelTest {

    @Test
    void scan() {
        TablePanel tablePanel = new TablePanel();
        tablePanel.scan(ClassLoader.getSystemResourceAsStream("testcase.txt"));
    }

    @Test
    void draw() throws IOException {
        TablePanel tablePanel = new TablePanel();
        tablePanel.scan(ClassLoader.getSystemResourceAsStream("testcase.txt"));
        tablePanel.draw();
    }
}