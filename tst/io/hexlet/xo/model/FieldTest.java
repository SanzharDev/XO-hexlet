package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {
        final Field field = new Field();
        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void setFigureWhenAlreadyOccupied() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;
        field.setFigure(inputPoint, inputFigure);
        try {
            field.setFigure(inputPoint, inputFigure);
            fail(); // JUnit завалит тест если исполнение программы дойдет до этой строки
        } catch (final AlreadyOccupiedException e) {}
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);
        /*
            Мы не можем взять фигуру из точки с отрицательной координаты и поэтому тест не должен дойти до 49 строки и перейти в catch.
         */
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail(); // JUnit завалит тест если исполнение программы дойдет до этой строки
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,-1);
        /*
            Мы не можем взять фигуру из точки с отрицательной координаты и поэтому тест не должен дойти до 49 строки и перейти в catch.
         */
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail(); // JUnit завалит тест если исполнение программы дойдет до этой строки
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXYIsLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,-1);
        /*
            Мы не можем взять фигуру из точки с отрицательной координаты и поэтому тест не должен дойти до 49 строки и перейти в catch.
         */
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail(); // JUnit завалит тест если исполнение программы дойдет до этой строки
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXIsMoreThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1,0);
        /*
            Мы не можем взять фигуру из точки с отрицательной координаты и поэтому тест не должен дойти до 49 строки и перейти в catch.
         */
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail(); // JUnit завалит тест если исполнение программы дойдет до этой строки
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsMoreThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,field.getSize() + 1);
        /*
            Мы не можем взять фигуру из точки с отрицательной координаты и поэтому тест не должен дойти до 49 строки и перейти в catch.
         */
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail(); // JUnit завалит тест если исполнение программы дойдет до этой строки
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXYIsMoreThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1,field.getSize() + 1);
        /*
            Мы не можем взять фигуру из точки с отрицательной координаты и поэтому тест не должен дойти до 49 строки и перейти в catch.
         */
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail(); // JUnit завалит тест если исполнение программы дойдет до этой строки
        } catch (final InvalidPointException e) {}
    }



}