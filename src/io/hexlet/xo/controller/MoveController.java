package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field, final Figure figure, final Point point) throws Exception {
        field.setFigure(point, figure);
    }

}
