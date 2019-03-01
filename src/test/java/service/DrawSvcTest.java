package service;

import entity.panel.Grid;
import entity.tool.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrawSvcTest {

    @Test
    public void processDrawingCommand() {
        Grid[][] canvas = DrawSvc.processDrawingCommand(null, "l 1 2 6 2");
        assertEquals("no canvas while perfoming line drawing", true, canvas==null);

        canvas = DrawSvc.processDrawingCommand(canvas, "C 20 4");
        assertEquals("draw canvas", 6, canvas.length);

        canvas = DrawSvc.processDrawingCommand(canvas, "L 1 2 6 2");
        assertEquals("draw line", true, canvas[2][1].getValue() == 'x');
        assertEquals("draw line", false, canvas[1][1].getValue() == 'x');

        canvas = DrawSvc.processDrawingCommand(canvas, "R 14 1 18 3");
        assertEquals("draw rectangle", true, canvas[1][14].getValue() == 'x');
        assertEquals("draw rectangle", false, canvas[1][1].getValue() == 'x');

        canvas = DrawSvc.processDrawingCommand(canvas, "B 10 3 o");
        assertEquals("bucket fill", true, canvas[3][10].getValue() == 'o');
        assertEquals("bucket fill", true, canvas[1][11].getValue() == 'o');
    }

    @Test
    public void getDrawingTool() {
        DrawingTool drawingTool = DrawSvc.getDrawingTool("a b c");
        assertEquals("invalid command", true, drawingTool==null);

        drawingTool = DrawSvc.getDrawingTool("C 20 4");
        assertEquals("valid canvas command", true, drawingTool instanceof Canvas);

        drawingTool = DrawSvc.getDrawingTool("L 1 2 6 2");
        assertEquals("valid line command", true, drawingTool instanceof Line);

        drawingTool = DrawSvc.getDrawingTool("R 14 1 18 3");
        assertEquals("valid rectangle command", true, drawingTool instanceof Rectangle);

        drawingTool = DrawSvc.getDrawingTool("B 10 3 o");
        assertEquals("valid bucket fill command", true, drawingTool instanceof BucketFill);
    }
}