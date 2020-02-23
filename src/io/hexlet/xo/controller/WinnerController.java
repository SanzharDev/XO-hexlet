package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) throws InvalidPointException {
        final Figure diagonalWinner = winnerOnDiagonal(field);
        if (diagonalWinner != null) {
            return diagonalWinner;
        }
        for (int i = 0; i < field.getSize(); i++) {
            final Figure rowWinner = winnerOnRow    (field, i);
            if (rowWinner != null) {
                return rowWinner;
            }
            final Figure columnWinner = winnerOnColumn(field, i);
            if (columnWinner != null) {
                return columnWinner;
            }
        }
        return null;
    }

    private Figure winnerOnRow(final Field field,
                               final int row) throws InvalidPointException {
        for (int i = 0; i < field.getSize() - 1; i++) {
            final Figure current = field.getFigure(new Point(row, i));
            final Figure next = field.getFigure(new Point(row, i+1));
            if (current != null && next != null) {
                if (!current.equals(next)) {
                    return null;
                }
            } else {
                return null;
            }
        }
        return field.getFigure(new Point(row,0));
    }

    private Figure winnerOnColumn(final Field field,
                               final int column) throws InvalidPointException {
        for (int i = 0; i < field.getSize() - 1; i++) {
            final Figure current = field.getFigure(new Point(i, column));
            final Figure next = field.getFigure(new Point(i+1, column));
            if (current != null && next != null) {
                if (!current.equals(next)) {
                    return null;
                }
            } else {
                return null;
            }
        }
        return field.getFigure(new Point(0, column));
    }

    private Figure winnerOnDiagonal(final Field field) throws InvalidPointException {
        boolean primaryDiagonal = true;
        boolean secondaryDiagonal = true;
        final Figure centerElem = field.getFigure(new Point(field.getSize()/2, field.getSize()/2));
        if (centerElem == null) {
            return null;
        }

        for (int i = 0; i < field.getSize(); i++) {
            final Figure primElem = field.getFigure(new Point(i,i));
            final Figure secondElem = field.getFigure(new Point(i, field.getSize()-1-i));
            if (primElem == null) {
                primaryDiagonal = false;
            } else if (!primElem.equals(centerElem)) {
                primaryDiagonal = false;
            }
            if (secondElem == null) {
                secondaryDiagonal = false;
            } else if (!secondElem.equals(centerElem)) {
                secondaryDiagonal = false;
            }
        }

        if (primaryDiagonal || secondaryDiagonal) {
            return centerElem;
        }
        return null;
    }

}
