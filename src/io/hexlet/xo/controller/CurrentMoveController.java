package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) throws Exception {
        int countX = 0, countO = 0;
        for (int i = 0 ; i < field.getSize() ; i++) {
            for (int j = 0 ; j < field.getSize() ; j++) {
                final Point point = new Point(i,j);
                if (point == null) {
                    if (field.getFigure(point).equals(Figure.X)) {
                        countX++;
                    } else {
                        countO++;
                    }
                }
            }
        }
        if (countX == countO) {
            return Figure.X;
        } else {
            return Figure.O;
        }
    }

}
