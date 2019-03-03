package entity.tool;

import entity.panel.Grid;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanvasTest {

    @Test
    public void validateInput_CanvasSizeIsZero_False() throws IllegalArgumentException {
        Grid[][] canvas = new Grid[10][10];
        Canvas drawingTool = new Canvas("0", "10");
        assertEquals("invalid canvas size", false, drawingTool.validateInput(canvas));
    }

    @Test
    public void validateInput_ValidCanvasSize_True() throws IllegalArgumentException {
        Grid[][] canvas = new Grid[10][10];
        Canvas drawingTool = new Canvas("10", "10");
        assertEquals("valid canvas size", true, drawingTool.validateInput(canvas));
    }

    @Test
    public void validateInput_CanvasWidthGreaterThanMaxValue_False() throws IllegalArgumentException {
        Grid[][] canvas = new Grid[10][10];
        Canvas drawingTool = new Canvas("81", "10");
        assertEquals("Canvas width greater than max value", false, drawingTool.validateInput(canvas));
    }

    @Test
    public void validateInput_CanvasHeightGreaterThanMaxValue_False() throws IllegalArgumentException {
        Grid[][] canvas = new Grid[10][10];
        Canvas drawingTool = new Canvas("10", "301");
        assertEquals("canvas height greater than max value", false, drawingTool.validateInput(canvas));
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateInput_NonIntegerInputForWidthOrHeight_ExceptionThrown() {
        Grid[][] canvas = new Grid[10][10];
        Canvas drawingTool = new Canvas("ab", "10");
        drawingTool.validateInput(canvas);
    }

    @Test
    public void draw_ValidInput_Success() throws IllegalArgumentException {
        Canvas drawingTool = new Canvas("10", "10");
        Grid[][] canvas = drawingTool.draw(null);
        assertEquals("valid input for drawing a canvas", 12, canvas.length);
    }
}