package iofile.saveuserdata.src.main.gui;

import javax.swing.*;
import java.awt.*;

public class JOptionPaneDialogService implements DialogService {
    @Override
    public void showMessage(Component parentComponent, String message, String title, int messageType) {
        JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
    }
}

