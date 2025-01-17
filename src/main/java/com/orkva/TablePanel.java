package com.orkva;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.*;

/**
 * @author Shepherd Xie
 * @since 2025/1/16
 */
@Slf4j
public class TablePanel {
    private TreeSet<TableRow> tableRows;
    private String[] sort;
    private int maxValue;

    public void scan(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        int lines = Integer.parseInt(scanner.nextLine());
        String sort = scanner.nextLine();
        this.sort = sort.split("\\s+");

        Comparator<TableRow> rowComparator = null;
        if (this.sort[0].equals("Name")) {
            rowComparator = Comparator.comparing(TableRow::getName);
        } else if (this.sort[0].equals("Value")) {
            rowComparator = Comparator.comparing(TableRow::getValue);
        }

        if (this.sort[1].equals("ASC")) {
            rowComparator = rowComparator;
        } else if (this.sort[1].equals("DESC")) {
            rowComparator = rowComparator.reversed();
        }

        tableRows = new TreeSet<>(rowComparator);
        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            log.debug("{}", line);
            String[] split = line.split(" ");
            String name = split[0];
            int value = Integer.parseInt(split[1]);
            tableRows.add(new TableRow(name, value));
        }
        log.info("{}", tableRows);
    }

    public void draw() {
        StringBuilder sb = new StringBuilder();
        int[] widths = getWidths();
        drawTop(sb, widths);
        drawBody(sb, widths);
        drawBottom(sb, widths);
        System.out.println(sb);
    }

    private int[] getWidths() {
        int[] widths = new int[2];
        tableRows.forEach(tableRow -> {
            widths[0] = Math.max(tableRow.name.length(), widths[0]);
            maxValue = Math.max(tableRow.value, maxValue);
        });
        widths[1] = 20;
        return widths;
    }


    private void drawBody(StringBuilder sb, int[] widths) {
        Iterator<TableRow> iterator = tableRows.iterator();
        while (iterator.hasNext()) {
            drawRowData(sb, widths, iterator.next());

            if (!iterator.hasNext()) {
                continue;
            }

            drawBoundRow(sb, widths);
        }
    }

    private static void drawBoundRow(StringBuilder sb, int[] widths) {
        sb.append('├');
        Collections.nCopies(widths[0], '─').forEach(sb::append);
        sb.append('┼');
        Collections.nCopies(widths[1], '─').forEach(sb::append);
        sb.append('┤').append('\n');
    }

    private void drawRowData(StringBuilder sb, int[] widths, TableRow row) {
        sb.append('│');
        drawRowName(sb, row, widths);
        sb.append('│');
        drawRowValue(sb, row, widths);
        sb.append('│').append('\n');
    }

    private void drawRowName(StringBuilder sb, TableRow row, int[] widths) {
        int spaces = widths[0] - row.name.length();
        Collections.nCopies(spaces, ' ').forEach(sb::append);
        sb.append(row.name);
    }

    private void drawRowValue(StringBuilder sb, TableRow row, int[] widths) {
        int blocks = (row.value * widths[1]) / maxValue;
        Collections.nCopies(blocks, '█').forEach(sb::append);
        int spaces = widths[1] - blocks;
        Collections.nCopies(spaces, ' ').forEach(sb::append);
    }

    private void drawTop(StringBuilder sb, int[] widths) {
        sb.append('┌');
        Collections.nCopies(widths[0], '─').forEach(sb::append);
        sb.append('┬');
        Collections.nCopies(widths[1], '─').forEach(sb::append);
        sb.append('┐').append('\n');
    }

    private void drawBottom(StringBuilder sb, int[] widths) {
        sb.append('└');
        Collections.nCopies(widths[0], '─').forEach(sb::append);
        sb.append('┴');
        Collections.nCopies(widths[1], '─').forEach(sb::append);
        sb.append('┘');
    }
}
