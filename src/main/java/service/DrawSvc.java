package service;

import entity.panel.Grid;
import entity.tool.*;
import utility.InputValidator;

public class DrawSvc {
    public static Grid[][] processDrawingCommand(Grid[][] canvas, String input) {
        if(InputValidator.isValid(input)) {
            DrawingTool drawingTool = getDrawingTool(input);
            if(InputValidator.isValid(drawingTool) && drawingTool.validateInput(canvas)) {
                canvas = drawingTool.draw(canvas);
                printDrawing(canvas);
            }
        }
        return canvas;
    }

    public static DrawingTool getDrawingTool(String input) {
        DrawingTool drawingTool = null;
        String[] inputs = input.split("\\s+");

        try {
            String command = inputs[0];
            switch(command) {
                case "c": case "C":
                    if(inputs.length == 3) drawingTool = new Canvas(inputs[1], inputs[2]);
                    else System.out.println("invalid argument size for creating a canvas");
                    break;

                case "l": case "L":
                    if(inputs.length == 5) drawingTool = new Line(inputs[1], inputs[2], inputs[3], inputs[4]);
                    else System.out.println("invalid argument size for drawing a line");
                    break;

                case "r": case "R":
                    if(inputs.length == 5) drawingTool = new Rectangle(inputs[1], inputs[2], inputs[3], inputs[4]);
                    else System.out.println("invalid argument size for drawing a rectangle");
                    break;

                case "b": case "B":
                    if(inputs.length == 3 || inputs.length == 4) {
                        String color = (inputs.length==3)? " ":inputs[3];
                        drawingTool = new BucketFill(inputs[1], inputs[2], color);
                    } else System.out.println("invalid argument size for drawing a block");
                    break;
                default:
                    System.out.println("unknown input command: " + inputs[0]);
            }
        } catch (Exception e) {
            drawingTool = null;
        }
        return drawingTool;
    }

    public static void printDrawing(Grid[][] canvas) {
        for(int i = 0; i < canvas.length; i++) {
            for(int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j].getValue());
            }
            System.out.println();
        }
    }
}
