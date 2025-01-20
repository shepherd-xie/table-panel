package com.orkva;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Shepherd Xie
 * @since 2025/1/20
 */
class TablePanelTest {

    @Test
    void read() {
    }

    @Test
    void draw() {
        TablePanel tablePanel = new TablePanel();
        tablePanel.read(ClassLoader.getSystemResourceAsStream("testcase.txt")).draw();
    }
}