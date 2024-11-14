package iofile.saveuserdata.src.main;

import iofile.saveuserdata.src.main.gui.SaveData;

import javax.swing.SwingUtilities;

/**
 * The main entry point for launching the Text Saver application.
 */
public class SaveUserDataApp {

    /**
     * Main method to start the application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SaveData app = new SaveData();
            app.setVisible(true); // Show the main application window
        });
    }
}
