package com.orkva;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author Shepherd Xie
 * @since 2025/1/16
 */
class TableTest {

    @Test
    void scan() {
        Table table = new Table();
        table.scan(ClassLoader.getSystemResourceAsStream("testcase.txt"));
    }

    @Test
    void draw() throws IOException {
        Table table = new Table();
        table.scan(ClassLoader.getSystemResourceAsStream("testcase.txt"));
    }
}