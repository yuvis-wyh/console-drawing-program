package utility;

import entity.panel.Grid;
import entity.panel.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidatorTest {

    @Test
    public void isValidString() {
        assertEquals("empty string", false, InputValidator.isValid(""));
        assertEquals("string with value", true, InputValidator.isValid("test"));
    }

    @Test
    public void isValidObject() {
        Grid[][] canvas = null;
        assertEquals("empty canvas", false, InputValidator.isValid(canvas));

        canvas = new Grid[5][5];
        assertEquals("initialized with value", true, InputValidator.isValid(canvas));
    }

    @Test
    public void isValidNum() {
        assertEquals("string with alphabet", false, InputValidator.isValidNum("a"));
        assertEquals("string with number", true, InputValidator.isValidNum("12"));
    }

    @Test
    public void isValidPoint() {
        Grid[][] canvas = new Grid[5][5];
        assertEquals("point not within the canvas", false, InputValidator.isValidPoint(canvas, new Point(2,7)));
        assertEquals("point within the canvas", true, InputValidator.isValidPoint(canvas, new Point(1,1)));
    }

    @Test
    public void isValidColor() {
        assertEquals("invalid color entered", false, InputValidator.isValidColor("ab"));
        assertEquals("valid color entered", true, InputValidator.isValidColor("o"));
    }
}