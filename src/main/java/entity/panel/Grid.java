package entity.panel;

import utility.Constant;

public class Grid {
    private boolean colorFilled = false;
    private char value = 32;

    public Grid() {}

    public boolean isColorFilled() {
        return colorFilled;
    }

    public void setColorFilled(boolean colorFilled) {
        this.colorFilled = colorFilled;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isBorder() {
        return value == Constant.BORDER_UP_DOWN || value == Constant.BORDER_LEFT_RIGHT;
    }
}
