package entity.tool;

import entity.panel.Grid;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanvasTest {

    @Test
    public void validateInput() throws Exception {
        Canvas drawingTool1= new Canvas("0", "10");
        Canvas drawingTool2= new Canvas("10", "10");
        Grid[][] canvas = new Grid[10][10];

        assertEquals("invalid canvas size", false, drawingTool1.validateInput(canvas));
        assertEquals("valid canvas size", true, drawingTool2.validateInput(canvas));
    }

    @Test
    public void draw() throws Exception {
        Canvas drawingTool= new Canvas("10", "10");
        Grid[][] canvas = drawingTool.draw(null);

        assertEquals("height of the canvas", 12, canvas.length);
    }
}