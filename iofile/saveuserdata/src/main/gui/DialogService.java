package iofile.saveuserdata.src.main.gui;

import java.awt.Component;

public interface DialogService {
    void showMessage(Component parentComponent, String message, String title, int messageType);
}
