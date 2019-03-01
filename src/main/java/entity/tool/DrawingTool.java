package entity.tool;

import entity.panel.Grid;

public interface DrawingTool {
    public boolean validateInput(Grid[][] canvas);
    public Grid[][] draw(Grid[][] canvas);
}
