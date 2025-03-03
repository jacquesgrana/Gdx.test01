package com.mycompany.test01.Entity;

import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Interface.FileChooser;
import com.mycompany.test01.Interface.FileChooserListener;

import javax.swing.JFileChooser;
import java.io.File;

public class DesktopFileChooser implements FileChooser {
    @Override
    public void openLoadFileChooser(FileChooserListener listener) {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            listener.selected(new FileHandle(selectedFile), "LOAD");
        } else {
            listener.cancellation();
        }
    }

    @Override
    public void openSaveFileChooser(FileChooserListener listener) {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            listener.selected(new FileHandle(selectedFile), "SAVE");
        } else {
            listener.cancellation();
        }
    }
}
