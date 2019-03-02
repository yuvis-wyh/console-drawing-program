package entity.tool;

import entity.panel.Grid;
import utility.Constant;
import utility.InputValidator;

public class Canvas implements DrawingTool{
    private int width;
    private int height;

    public Canvas(String width, String height) throws Exception {
        if(InputValidator.isValidNum(width) && InputValidator.isValidNum(height)) {
            this.width = Integer.parseInt(width);
            this.height = Integer.parseInt(height);
        } else {
            throw new Exception();
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean validateInput(Grid[][] canvas) {
        boolean result = width<= 80 && width>0 && height<= 300 && height>0;
        if(!result) System.out.println("width should be between 1 and 80; height should be between 1 and 300 ");
        return result;
    }

    public Grid[][] draw(Grid[][] canvas) {
        canvas = new Grid[height+2][width+2];
        for(int i = 0; i < canvas.length; i++) {
            for(int j = 0; j < canvas[i].length; j++) {
                char value = 0;
                if(i == 0 || i == height+1) {
                    value = Constant.BORDER_UP_DOWN;
                } else if (j == 0 || j == width+1) {
                    value = Constant.BORDER_LEFT_RIGHT;
                }

                canvas[i][j] = new Grid();
                if(value != 0) {
                    canvas[i][j].setValue(value);
                }
            }
        }
        return canvas;
    }
}
