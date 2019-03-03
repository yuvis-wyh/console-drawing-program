package entity.tool;

import entity.panel.Grid;
import entity.panel.Point;
import utility.Constant;
import utility.InputValidator;

public class Rectangle implements DrawingTool{
    private Point startPoint;
    private Point endPoint;

    public Rectangle(String startPointX, String startPointY, String endPointX, String endPointY) throws IllegalArgumentException {
        if(InputValidator.isValidNum(startPointX) && InputValidator.isValidNum(startPointY)
                && InputValidator.isValidNum(endPointX) && InputValidator.isValidNum(endPointY)) {
            int valStartPointX = Integer.parseInt(startPointX);
            int valStartPointY = Integer.parseInt(startPointY);
            int valEndPointX = Integer.parseInt(endPointX);
            int valEndPointY = Integer.parseInt(endPointY);
            this.startPoint = new Point(valStartPointX, valStartPointY);
            this.endPoint = new Point(valEndPointX, valEndPointY);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public boolean validateInput(Grid[][] canvas) {
        boolean result = false;
        if(InputValidator.isValid(canvas)) result = InputValidator.isValidPoint(canvas, startPoint) && InputValidator.isValidPoint(canvas, endPoint);
        else System.out.println("please define canvas size before draw a rectangle");
        return result;
    }

    public Grid[][] draw(Grid[][] canvas) {
        int minY = Math.min(this.startPoint.getY(), this.endPoint.getY());
        int maxY = Math.max(this.startPoint.getY(), this.endPoint.getY());
        int minX = Math.min(this.startPoint.getX(), this.endPoint.getX());
        int maxX = Math.max(this.startPoint.getX(), this.endPoint.getX());

        for(int i=minY; i<=maxY; i++) {
            for(int j=minX; j<=maxX; j++) {
                if(i==minY || i==maxY || j==minX || j==maxX) {
                    canvas[i][j].setColorFilled(false);
                    canvas[i][j].setValue(Constant.LINE_MARK);
                }
            }
        }
        return canvas;
    }
}
