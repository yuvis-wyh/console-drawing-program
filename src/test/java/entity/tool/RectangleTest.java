package entity.tool;

import entity.panel.Grid;
import org.junit.Before;
import org.junit.Test;
import utility.Constant;

import static org.junit.Assert.*;

public class RectangleTest {

    Grid[][] canvas;
    @Before
    public void initialize() throws IllegalArgumentException {
        Canvas canvasDrawingTool = new Canvas("20","4");
        canvas = canvasDrawingTool.draw(canvas);
    }

    @Test
    public void validateInput_InvalidStartPointInput_False() throws IllegalArgumentException {
        Rectangle rectangleDrawingTool = new Rectangle("1", "-10","6","2");
        assertEquals("start point out of range", false, rectangleDrawingTool.validateInput(canvas));
    }

    @Test
    public void validateInput_InvalidEndPointInput_False() throws IllegalArgumentException {
        Rectangle rectangleDrawingTool = new Rectangle("1", "10","6","22");
        assertEquals("end point out of range", false, rectangleDrawingTool.validateInput(canvas));
    }

    @Test
    public void validateInput_ValidStartAndEndPointInput_True() throws IllegalArgumentException {
        Rectangle rectangleDrawingTool = new Rectangle("1", "2", "6", "2");
        assertEquals("valid start and end points", true, rectangleDrawingTool.validateInput(canvas));
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateInput_NonIntegerInput_ExceptionThrown() {
        Rectangle rectangleDrawingTool = new Rectangle("1", "b", "6", "2");
        rectangleDrawingTool.validateInput(canvas);
    }

    @Test
    public void draw() throws IllegalArgumentException {
        Rectangle drawingTool= new Rectangle("14", "1", "18", "3");
        canvas = drawingTool.draw(canvas);
        assertEquals("mark x on grids",true, canvas[1][14].getValue()==Constant.LINE_MARK);
    }
}