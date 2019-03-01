package utility;

import entity.panel.Grid;
import entity.panel.Point;

public class InputValidator {
    public static boolean isValid(String input) {
        return !(input==null || input.equals(""));
    }

    public static boolean isValid(Object object) {
        return object!=null;
    }

    public static boolean isValidNum(String input) {
        boolean result = true;
        try {
            int num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            result = false;
            System.out.println("position input: " + input + " must be integer");
        }
        return result;
    }

    public static boolean isValidPoint(Grid[][] canvas, Point point) {
        boolean result =  canvas.length-2 >= point.getY() && point.getY() > 0
                && canvas[0].length-2 >= point.getX() && point.getX() > 0;
        if(!result) System.out.println("[" + point.getX() + "," + point.getY() + "] is out of range");
        return result;
    }

    public static boolean isValidColor(String input) {
        boolean result = (input.length()<=1);
        if(!result) System.out.println("invalid color entered");
        return result;
    }
}
