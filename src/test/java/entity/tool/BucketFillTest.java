package entity.tool;

import entity.panel.Grid;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BucketFillTest {

    Grid[][] canvas;
    @Before
    public void initialize() throws IllegalArgumentException {
        Canvas canvasDrawingTool = new Canvas("20","4");
        canvas = canvasDrawingTool.draw(canvas);
    }

    @Test
    public void validateInput_InvalidPointInput_False() throws IllegalArgumentException {
        BucketFill bucketFillDrawingTool = new BucketFill("1", "-2","o");
        assertEquals("input point out of range", false, bucketFillDrawingTool.validateInput(canvas));
    }

    @Test
    public void validateInput_ValidPointInput_True() throws IllegalArgumentException {
        BucketFill bucketFillDrawingTool = new BucketFill("1", "2", "o");
        assertEquals("valid point input", true, bucketFillDrawingTool.validateInput(canvas));
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateInput_NonIntegerInput_ExceptionThrown() {
        BucketFill bucketFillDrawingTool = new BucketFill("a", "2", "o");
        bucketFillDrawingTool.validateInput(canvas);
    }

    @Test
    public void draw_ValidInput_Success() throws IllegalArgumentException {
        BucketFill drawingTool= new BucketFill("10", "3", "o");
        canvas = drawingTool.draw(canvas);
        assertEquals("mark 'o' on grid",true, canvas[3][10].getValue()=='o');
    }

    @Test
    public void colorGrid_ValidInput_Success() throws IllegalArgumentException {
        BucketFill drawingTool= new BucketFill("10", "3", "o");
        canvas = drawingTool.colorGrid(canvas, 3, 10, 'o');
        assertEquals("mark 'o' on grid",true, canvas[3][10].getValue()=='o');
    }
}