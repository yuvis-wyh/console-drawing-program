package entity.tool;

import entity.panel.Grid;
import entity.panel.Point;
import utility.Constant;
import utility.InputValidator;

public class BucketFill implements DrawingTool{
    private Point point;
    private char color;

    public BucketFill (String pointX, String pointY, String color) throws Exception {
        if(InputValidator.isValidNum(pointX) && InputValidator.isValidNum(pointY)
                && InputValidator.isValidColor(color)) {
            int valPointX = Integer.parseInt(pointX);
            int valPointY = Integer.parseInt(pointY);

            point = new Point(valPointX, valPointY);
            this.color = color.charAt(0);
        } else {
            throw new Exception();
        }
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public boolean validateInput(Grid[][] canvas) {
        boolean result = false;
        if(InputValidator.isValid(canvas)) result = InputValidator.isValidPoint(canvas, point);
        else System.out.println("please define canvas size before perform bucket fill");

        if(result) {
            int row = point.getY();
            int column = point.getX();

            Grid curr = canvas[row][column];
            if(curr.getValue() == Constant.LINE_MARK && !curr.isColorFilled()) {
                System.out.println("[" + point.getX() + "," + point.getY() + "] is occupied");
                result = false;
            } else if (curr.getValue() == color) {
                System.out.println("[" + point.getX() + "," + point.getY() + "] is occupied with color: " + color);
                result = false;
            }
        }
        return result;
    }

    public Grid[][] draw(Grid[][] canvas) {
        canvas = colorGrid(canvas, point.getY(), point.getX(), this.color);
        return canvas;
    }

    public static Grid[][] colorGrid(Grid[][] canvas, int row, int column, char color) {
        int height = canvas.length-2;
        int width = canvas[0].length-2;

        Grid curr = canvas[row][column];
        if(curr.isBorder()) return canvas;
        if(curr.getValue() == Constant.LINE_MARK && !curr.isColorFilled()) return canvas;
        if(curr.isColorFilled() && curr.getValue() == color) return canvas;

        canvas[row][column].setColorFilled(true);
        canvas[row][column].setValue(color);

        colorGrid(canvas, row-1, column, color);
        colorGrid(canvas, row+1, column, color);
        colorGrid(canvas, row, column-1, color);
        colorGrid(canvas, row, column+1, color);
        return canvas;
    }
}
