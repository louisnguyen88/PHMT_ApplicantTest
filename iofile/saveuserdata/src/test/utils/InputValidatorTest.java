package iofile.saveuserdata.src.test.utils;

import iofile.saveuserdata.src.main.utils.InputValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    public void testIsTextValid_NonEmptyText() {
        assertTrue(inputValidator.isTextValid("Hello, World!"));
    }

    @Test
    public void testIsTextValid_EmptyText() {
        assertFalse(inputValidator.isTextValid(""));
    }

    @Test
    public void testIsTextValid_NullText() {
        assertFalse(inputValidator.isTextValid(null));
    }

    @Test
    public void testIsTextValid_WhitespaceOnlyText() {
        assertFalse(inputValidator.isTextValid("   "));
    }
}
