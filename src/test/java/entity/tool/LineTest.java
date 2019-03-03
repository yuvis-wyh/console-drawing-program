package entity.tool;

import entity.panel.Grid;
import org.junit.Before;
import org.junit.Test;
import utility.Constant;

import static org.junit.Assert.*;

public class LineTest {

    Grid[][] canvas;
    @Before
    public void initialize() throws IllegalArgumentException {
        Canvas canvasDrawingTool = new Canvas("20","4");
        canvas = canvasDrawingTool.draw(canvas);
    }

    @Test
    public void validateInput_InvalidStartPointInput_False() throws IllegalArgumentException {
        Line lineDrawingTool = new Line("1", "-10","6","2");
        assertEquals("start point out of range", false, lineDrawingTool.validateInput(canvas));
    }

    @Test
    public void validateInput_InvalidEndPointInput_False() throws IllegalArgumentException {
        Line lineDrawingTool = new Line("1", "10","6","22");
        assertEquals("end point out of range", false, lineDrawingTool.validateInput(canvas));
    }

    @Test
    public void validateInput_ValidStartAndEndPointInput_True() throws IllegalArgumentException {
        Line lineDrawingTool = new Line("1", "2", "6", "2");
        assertEquals("valid start and end points", true, lineDrawingTool.validateInput(canvas));
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateInput_NonIntegerInput_ExceptionThrown() {
        Line lineDrawingTool = new Line("1", "b", "6", "2");
        lineDrawingTool.validateInput(canvas);
    }

    @Test
    public void draw_ValidInput_Success() throws IllegalArgumentException {
        Line drawingTool= new Line("1", "2", "6", "2");
        canvas = drawingTool.draw(canvas);
        assertEquals("mark a line on grid",true, canvas[2][1].getValue()==Constant.LINE_MARK);
    }
}