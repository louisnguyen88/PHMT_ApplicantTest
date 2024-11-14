package iofile.saveuserdata.src.main.gui;

import iofile.saveuserdata.src.main.utils.InputValidator;
import iofile.saveuserdata.src.main.utils.TextFileSaver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Optional;

public class SaveData extends JFrame {

    private JTextArea textArea;
    private JButton saveButton;
    private final InputValidator inputValidator;
    private final TextFileSaver textFileSaver;
    private final DialogService dialogService;
    private final JFileChooser fileChooser;

    public SaveData() {
        this(new InputValidator(), new TextFileSaver(), new JOptionPaneDialogService(), new JFileChooser());
    }

    public SaveData(InputValidator inputValidator, TextFileSaver textFileSaver, DialogService dialogService, JFileChooser fileChooser) {
        this.inputValidator = inputValidator;
        this.textFileSaver = textFileSaver;
        this.dialogService = dialogService;
        this.fileChooser = fileChooser;
        initComponents();
    }

    private void initComponents() {
        setTitle("Text Saver");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int option = fileChooser.showSaveDialog(SaveData.this);

            Optional.of(option)
                    .filter(opt -> opt == JFileChooser.APPROVE_OPTION)
                    .map(opt -> fileChooser.getSelectedFile())
                    .ifPresentOrElse(
                            this::handleFileSave,
                            () -> dialogService.showMessage(SaveData.this,
                                    "Save operation canceled.",
                                    "Canceled", JOptionPane.INFORMATION_MESSAGE)
                    );
        }

        private void handleFileSave(File file) {
            Optional.ofNullable(textArea.getText())
                    .filter(inputValidator::isTextValid)
                    .ifPresentOrElse(
                            text -> {
                                String message = textFileSaver.saveTextToFile(file, text);
                                boolean success = message.equals("File saved successfully!");
                                dialogService.showMessage(SaveData.this, message,
                                        success ? "Success" : "Error",
                                        success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
                                if (success) dispose();
                            },
                            () -> dialogService.showMessage(SaveData.this,
                                    "The text area is empty. Please enter some text before saving.",
                                    "Empty Input", JOptionPane.WARNING_MESSAGE)
                    );
        }
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JButton getSaveButton() {
        return saveButton;
    }
}



