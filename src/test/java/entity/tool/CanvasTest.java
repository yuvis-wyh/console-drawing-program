package entity.tool;

import entity.panel.Grid;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanvasTest {

    @Test
    public void validateInput() throws Exception {
        Grid[][] canvas = new Grid[10][10];
        Canvas drawingTool = new Canvas("0", "10");
        assertEquals("invalid canvas size", false, drawingTool.validateInput(canvas));

        drawingTool = new Canvas("10", "10");
        assertEquals("valid canvas size", true, drawingTool.validateInput(canvas));

        drawingTool = new Canvas("81", "10");
        assertEquals("invalid canvas size", false, drawingTool.validateInput(canvas));

        drawingTool = new Canvas("10", "301");
        assertEquals("invalid canvas size", false, drawingTool.validateInput(canvas));
    }

    @Test
    public void draw() throws Exception {
        Canvas drawingTool = new Canvas("10", "10");
        Grid[][] canvas = drawingTool.draw(null);

        assertEquals("height of the canvas", 12, canvas.length);
    }
}