package entity.tool;

import entity.panel.Grid;
import entity.panel.Point;
import utility.Constant;
import utility.InputValidator;

public class Line implements DrawingTool{
    private Point startPoint;
    private Point endPoint;

    public Line(String startPointX, String startPointY, String endPointX, String endPointY) throws IllegalArgumentException {
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
        if(InputValidator.isValid(canvas))
            result = InputValidator.isValidPoint(canvas, startPoint) && InputValidator.isValidPoint(canvas, endPoint);
        else System.out.println("please define canvas size before draw a line");
        return result;
    }

    public Grid[][] draw(Grid[][] canvas) {
        int startPointX = startPoint.getX();
        int startPointY = startPoint.getY();
        int endPointX = endPoint.getX();
        int endPointY = endPoint.getY();

        int start, end;
        if(startPointX == endPointX) {
            start = Math.min(startPointY, endPointY);
            end = Math.max(startPointY, endPointY);

            for(int i=start; i<=end; i++) {
                canvas[i][startPointX].setColorFilled(false);
                canvas[i][startPointX].setValue(Constant.LINE_MARK);
            }
        } else if (startPointY == endPointY) {
            start = Math.min(startPointX, endPointX);
            end = Math.max(startPointX, endPointX);

            for(int i=start; i<=end; i++) {
                canvas[startPointY][i].setColorFilled(false);
                canvas[startPointY][i].setValue(Constant.LINE_MARK);
            }
        }
        return canvas;
    }
}
