package entity.tool;

import entity.panel.Grid;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    Grid[][] canvas;
    @Before
    public void initialize() throws Exception {
        Canvas canvasDrawingTool = new Canvas("20","4");
        canvas = canvasDrawingTool.draw(canvas);
    }

    @Test
    public void validateInput() throws Exception {
        Rectangle drawingTool1= new Rectangle("1", "-10","6","2");
        Rectangle drawingTool2= new Rectangle("1", "2", "6", "2");

        assertEquals("start point out of range", false, drawingTool1.validateInput(canvas));
        assertEquals("valid start and end points", true, drawingTool2.validateInput(canvas));
    }

    @Test
    public void draw() throws Exception {
        Rectangle drawingTool= new Rectangle("14", "1", "18", "3");
        canvas = drawingTool.draw(canvas);

        assertEquals("mark x on grid",true, canvas[1][14].getValue()=='x');
    }
}