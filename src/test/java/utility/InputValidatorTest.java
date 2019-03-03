package utility;

import entity.panel.Grid;
import entity.panel.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidatorTest {

    @Test
    public void isValidString_EmptyInput_False() {
        assertEquals("empty string", false, InputValidator.isValid(""));
    }

    @Test
    public void isValidString_NullInput_False() {
        assertEquals("empty string", false, InputValidator.isValid(null));
    }

    @Test
    public void isValidString_ValidInput_True() {
        assertEquals("string with value", true, InputValidator.isValid("test"));
    }

    @Test
    public void isValidObject_NullInput_False() {
        Point point = null;
        assertEquals("null object", false, InputValidator.isValid(point));
    }

    @Test
    public void isValidObject_ValidInput_True() {
        Point point = new Point(1,1);
        assertEquals("valid object", true, InputValidator.isValid(point));
    }

    @Test
    public void isValidNum_StringInput_False() {
        assertEquals("string with alphabet", false, InputValidator.isValidNum("a"));
    }

    @Test
    public void isValidNum_PositiveIntegerInput_True() {
        assertEquals("string with number", true, InputValidator.isValidNum("12"));
    }

    @Test
    public void isValidNum_NegativeIntegerInput_True() {
        assertEquals("string with number", true, InputValidator.isValidNum("-12"));
    }

    @Test
    public void isValidPoint_PointNotWithinCanvas_False() {
        Grid[][] canvas = new Grid[5][5];
        assertEquals("point not within the canvas", false, InputValidator.isValidPoint(canvas, new Point(2,7)));
    }

    @Test
    public void isValidPoint_PointWithinCanvas_True() {
        Grid[][] canvas = new Grid[5][5];
        assertEquals("point within the canvas", true, InputValidator.isValidPoint(canvas, new Point(1,1)));
    }

    @Test
    public void isValidColor_StringSizeGreaterThanOne_False() {
        assertEquals("invalid color entered", false, InputValidator.isValidColor("ab"));
    }

    @Test
    public void isValidColor_StringSizeEqualOne_True() {
        assertEquals("valid color entered", true, InputValidator.isValidColor("o"));
    }
}