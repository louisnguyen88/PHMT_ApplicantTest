package iofile.saveuserdata.src.test.utils;

import iofile.saveuserdata.src.main.utils.TextFileSaver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.*;

class TextFileSaverTest {

    private TextFileSaver textFileSaver;
    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        textFileSaver = new TextFileSaver();
        tempFile = File.createTempFile("testFile", ".txt");
    }

    @AfterEach
    void tearDown() {
        if (tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    void testSaveTextToFile_Success() {
        String text = "Sample text for testing.";
        String result = textFileSaver.saveTextToFile(tempFile, text);

        // Verify the file save was successful
        assertEquals("File saved successfully!", result);

        // Verify the file content matches the input text
        try {
            String fileContent = Files.readString(tempFile.toPath());
            assertEquals(text, fileContent);
        } catch (IOException e) {
            fail("Failed to read the temp file.");
        }
    }

    @Test
    void testSaveTextToFile_EmptyText() {
        String result = textFileSaver.saveTextToFile(tempFile, "");
        assertEquals("File saved successfully!", result);
    }

    @Test
    void testSaveTextToFile_FilePermissionIssue() {
        // Simulate a permission issue by making the file read-only
        tempFile.setReadOnly();

        String result = textFileSaver.saveTextToFile(tempFile, "This should fail due to permissions.");
        assertTrue(result.startsWith("An error occurred while saving the file:"));

        // Reset permissions for cleanup
        tempFile.setWritable(true);
    }
}
