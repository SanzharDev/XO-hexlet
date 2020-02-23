package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.Point;

public class Field {

    private final int FIELD_SIZE;

    private final int MIN_COORDINATE = 0;

    private final int MAX_COORDINATE;

    private final Figure[][] field;

    public Field() {
        this.FIELD_SIZE = 3;
        this.MAX_COORDINATE = FIELD_SIZE;
        field = new Figure[FIELD_SIZE][FIELD_SIZE];
    }

    public Field(int FIELD_SIZE, int MAX_COORDINATE, Figure[][] field) {
        this.FIELD_SIZE = FIELD_SIZE;
        this.MAX_COORDINATE = MAX_COORDINATE;
        this.field = field;
    }

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }

}
