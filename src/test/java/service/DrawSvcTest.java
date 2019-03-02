package service;

import entity.panel.Grid;
import entity.tool.*;
import org.junit.Test;
import utility.Constant;

import static org.junit.Assert.*;

public class DrawSvcTest {

    @Test
    public void processDrawingCommand() {
        Grid[][] canvas = DrawSvc.processDrawingCommand(null, "l 1 2 6 2");
        assertEquals("no canvas while performing line drawing", true, canvas==null);

        canvas = DrawSvc.processDrawingCommand(canvas, "C 20 4");
        assertEquals("draw canvas", 6, canvas.length);

        canvas = DrawSvc.processDrawingCommand(canvas, "L 1 2 6 2");
        assertEquals("draw line", true, canvas[2][1].getValue() == Constant.LINE_MARK);
        assertEquals("draw line", false, canvas[1][1].getValue() == Constant.LINE_MARK);

        canvas = DrawSvc.processDrawingCommand(canvas, "R 14 1 18 3");
        assertEquals("draw rectangle", true, canvas[1][14].getValue() == Constant.LINE_MARK);
        assertEquals("draw rectangle", false, canvas[1][1].getValue() == Constant.LINE_MARK);

        canvas = DrawSvc.processDrawingCommand(canvas, "B 10 3 o");
        assertEquals("bucket fill", true, canvas[3][10].getValue() == 'o');
        assertEquals("bucket fill", true, canvas[1][11].getValue() == 'o');
    }

    @Test
    public void testDefaultColorFilled() {
        Grid[][] canvas = DrawSvc.processDrawingCommand(null, "C 18 5");
        canvas = DrawSvc.processDrawingCommand(canvas, "L 1 3 7 3");
        canvas = DrawSvc.processDrawingCommand(canvas, "L 3 1 3 5");
        canvas = DrawSvc.processDrawingCommand(canvas, "B 1 1 o");
        assertEquals("bucket fill", true, canvas[1][1].getValue() == 'o');

        canvas = DrawSvc.processDrawingCommand(canvas, "B 1 1");
        assertEquals("bucket fill", true, canvas[1][11].getValue() == 32);
    }

    @Test
    public void testColorFilledOnDrawnLineGrid() {
        Grid[][] canvas = DrawSvc.processDrawingCommand(null, "C 18 5");
        canvas = DrawSvc.processDrawingCommand(canvas, "R 1 1 7 3");
        canvas = DrawSvc.processDrawingCommand(canvas, "B 1 1 o");
        assertEquals("bucket fill", true, canvas[1][1].getValue() != 'o');
    }

    @Test
    public void getDrawingTool() {
        DrawingTool drawingTool = DrawSvc.getDrawingTool("a b c");
        assertEquals("invalid command", true, drawingTool==null);

        drawingTool = DrawSvc.getDrawingTool("C 20 4");
        assertEquals("valid canvas command", true, drawingTool instanceof Canvas);

        drawingTool = DrawSvc.getDrawingTool("c 20 4");
        assertEquals("valid canvas command", true, drawingTool instanceof Canvas);

        drawingTool = DrawSvc.getDrawingTool("L 1 2 6 2");
        assertEquals("valid line command", true, drawingTool instanceof Line);

        drawingTool = DrawSvc.getDrawingTool("l 1 2 6 2");
        assertEquals("valid line command", true, drawingTool instanceof Line);

        drawingTool = DrawSvc.getDrawingTool("R 14 1 18 3");
        assertEquals("valid rectangle command", true, drawingTool instanceof Rectangle);

        drawingTool = DrawSvc.getDrawingTool("r 14 1 18 3");
        assertEquals("valid rectangle command", true, drawingTool instanceof Rectangle);

        drawingTool = DrawSvc.getDrawingTool("B 10 3 o");
        assertEquals("valid bucket fill command", true, drawingTool instanceof BucketFill);

        drawingTool = DrawSvc.getDrawingTool("b 10 3 o");
        assertEquals("valid bucket fill command", true, drawingTool instanceof BucketFill);
    }
}