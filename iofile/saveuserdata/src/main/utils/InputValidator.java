package iofile.saveuserdata.src.main.utils;

/**
 * A utility class for validating user input.
 */
public class InputValidator {

    /**
     * Validates if the provided text is non-null and non-empty after trimming.
     *
     * @param text The text to validate.
     * @return True if text is valid (not null or empty); otherwise, false.
     */
    public boolean isTextValid(String text) {
        return text != null && !text.trim().isEmpty();
    }
}

