package com.orkva.components;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author Shepherd Xie
 * @since 2025/1/19
 */
@AllArgsConstructor
public enum Alignment {
    LEFT(Alignment::drawLeft),
    RIGHT(Alignment::drawRight),
    CENTER(Alignment::drawCenter);

    private final AlignmentFunc alignmentFunc;

    interface AlignmentFunc {
        String drawFunc(int width, String value, char filling);
    }

    private static String drawLeft(int width, String value, char filling) {
        List<Character> fillings = Collections.nCopies(width - value.length(), filling);
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        fillings.forEach(sb::append);
        return sb.toString();
    }

    private static String drawRight(int width, String value, char filling) {
        List<Character> fillings = Collections.nCopies(width - value.length(), filling);
        StringBuilder sb = new StringBuilder();
        fillings.forEach(sb::append);
        sb.append(value);
        return sb.toString();
    }

    private static String drawCenter(int width, String value, char filling) {
        List<Character> fillingLeft = Collections.nCopies((width - value.length()) / 2, filling);
        List<Character> fillingRight = Collections.nCopies(width - value.length() - fillingLeft.size(), filling);
        StringBuilder sb = new StringBuilder();
        fillingLeft.forEach(sb::append);
        sb.append(value);
        fillingRight.forEach(sb::append);
        return sb.toString();
    }

    public String draw(int width, String value, char filling) {
        return alignmentFunc.drawFunc(width, value, filling);
    }
}