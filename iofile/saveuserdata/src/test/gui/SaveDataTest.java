package iofile.saveuserdata.src.test.gui;

import iofile.saveuserdata.src.main.gui.SaveData;
import iofile.saveuserdata.src.main.utils.InputValidator;
import iofile.saveuserdata.src.main.utils.TextFileSaver;
import iofile.saveuserdata.src.main.gui.DialogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SaveDataTest {

    @Mock
    private InputValidator inputValidatorMock;

    @Mock
    private TextFileSaver textFileSaverMock;

    @Mock
    private DialogService dialogServiceMock;

    @Mock
    private JFileChooser fileChooserMock;

    @InjectMocks
    private SaveData saveData;

    private ActionEvent mockEvent;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        saveData = new SaveData(inputValidatorMock, textFileSaverMock, dialogServiceMock, fileChooserMock);
        mockEvent = mock(ActionEvent.class);
    }

    @Test
    public void testSaveAction_WithValidText_ShowsSuccessMessageAndCloses() {
        String validText = "Valid content";
        JTextArea textArea = saveData.getTextArea();
        textArea.setText(validText);
        File mockFile = new File("testFile.txt");

        when(fileChooserMock.showSaveDialog(saveData)).thenReturn(JFileChooser.APPROVE_OPTION);
        when(fileChooserMock.getSelectedFile()).thenReturn(mockFile);
        when(inputValidatorMock.isTextValid(validText)).thenReturn(true);
        when(textFileSaverMock.saveTextToFile(any(File.class), eq(validText))).thenReturn("File saved successfully!");

        saveData.getSaveButton().getActionListeners()[0].actionPerformed(mockEvent);

        verify(dialogServiceMock).showMessage(saveData, "File saved successfully!",
                "Success", JOptionPane.INFORMATION_MESSAGE);
        verify(dialogServiceMock, never()).showMessage(any(), eq("The text area is empty. Please enter some text before saving."),
                eq("Empty Input"), eq(JOptionPane.WARNING_MESSAGE));
    }

    @Test
    public void testSaveAction_SaveCanceled_ShowsCancelMessage() {
        when(fileChooserMock.showSaveDialog(saveData)).thenReturn(JFileChooser.CANCEL_OPTION);

        saveData.getSaveButton().getActionListeners()[0].actionPerformed(mockEvent);

        verify(dialogServiceMock).showMessage(saveData,
                "Save operation canceled.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
    }

    @Test
    public void testSaveAction_WithEmptyText_ShowsWarningMessage() {
        File mockFile = new File("testFile.txt");
        // Set up the empty text area to simulate user input with empty content
        saveData.getTextArea().setText("");

        // Ensure JFileChooser simulates the "approve" (save) action
        when(fileChooserMock.showSaveDialog(saveData)).thenReturn(JFileChooser.APPROVE_OPTION);
        when(inputValidatorMock.isTextValid("")).thenReturn(false);

        // Manually invoke the save action without clicking, simulating button click
        when(fileChooserMock.getSelectedFile()).thenReturn(mockFile);
        saveData.getSaveButton().getActionListeners()[0].actionPerformed(mockEvent);

        // Verify that the empty text warning dialog is shown
        verify(dialogServiceMock).showMessage(
                eq(saveData),
                eq("The text area is empty. Please enter some text before saving."),
                eq("Empty Input"),
                eq(JOptionPane.WARNING_MESSAGE)
        );
    }


    @Test
    public void testSaveAction_ErrorSavingFile_ShowsErrorMessage() {
        String validText = "Valid content";
        JTextArea textArea = saveData.getTextArea();
        textArea.setText(validText);
        File mockFile = new File("testFile.txt");

        when(fileChooserMock.showSaveDialog(saveData)).thenReturn(JFileChooser.APPROVE_OPTION);
        when(fileChooserMock.getSelectedFile()).thenReturn(mockFile);
        when(inputValidatorMock.isTextValid(validText)).thenReturn(true);
        when(textFileSaverMock.saveTextToFile(any(File.class), eq(validText))).thenReturn("Failed to save file.");

        saveData.getSaveButton().getActionListeners()[0].actionPerformed(mockEvent);

        verify(dialogServiceMock).showMessage(saveData, "Failed to save file.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}





