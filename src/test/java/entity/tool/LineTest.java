package entity.tool;

import entity.panel.Grid;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {

    Grid[][] canvas;
    @Before
    public void initialize() throws Exception {
        Canvas canvasDrawingTool = new Canvas("20","4");
        canvas = canvasDrawingTool.draw(canvas);
    }

    @Test
    public void validateInput() throws Exception {
        Line drawingTool1= new Line("1", "-10","6","2");
        Line drawingTool2= new Line("1", "2", "6", "2");

        assertEquals("start point out of range", false, drawingTool1.validateInput(canvas));
        assertEquals("valid start and end points", true, drawingTool2.validateInput(canvas));
    }

    @Test
    public void draw() throws Exception {
        Line drawingTool= new Line("1", "2", "6", "2");
        canvas = drawingTool.draw(canvas);

        assertEquals("mark a line on grid",true, canvas[2][1].getValue()=='x');
    }
}