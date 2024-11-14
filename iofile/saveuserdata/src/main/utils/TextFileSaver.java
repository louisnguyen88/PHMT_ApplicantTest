package iofile.saveuserdata.src.main.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A utility class for handling file-saving operations.
 */
public class TextFileSaver {

    /**
     * Saves the given text to the specified file.
     *
     * @param file The file to save text to.
     * @param text The text content to save.
     * @return A success or error message indicating the result.
     */
    public String saveTextToFile(File file, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(text);
            return "File saved successfully!";
        } catch (IOException ex) {
            return "An error occurred while saving the file: " + ex.getMessage();
        }
    }
}

