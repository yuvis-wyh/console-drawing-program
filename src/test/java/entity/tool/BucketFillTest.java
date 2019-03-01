package entity.tool;

import entity.panel.Grid;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BucketFillTest {

    Grid[][] canvas;
    @Before
    public void initialize() throws Exception {
        Canvas canvasDrawingTool = new Canvas("20","4");
        canvas = canvasDrawingTool.draw(canvas);
    }

    @Test
    public void validateInput() throws Exception {
        BucketFill drawingTool1 = new BucketFill("1", "-2","o");
        BucketFill drawingTool2 = new BucketFill("1", "2", "o");

        assertEquals("start point out of range", false, drawingTool1.validateInput(canvas));
        assertEquals("valid start and end points", true, drawingTool2.validateInput(canvas));
    }

    @Test
    public void draw() throws Exception {
        BucketFill drawingTool= new BucketFill("10", "3", "o");
        canvas = drawingTool.draw(canvas);

        assertEquals("mark 'o' on grid",true, canvas[3][10].getValue()=='o');
    }

    @Test
    public void colorGrid() throws Exception {
        BucketFill drawingTool= new BucketFill("10", "3", "o");
        canvas = drawingTool.colorGrid(canvas, 3, 10, 'o');

        assertEquals("mark 'o' on grid",true, canvas[3][10].getValue()=='o');
    }
}