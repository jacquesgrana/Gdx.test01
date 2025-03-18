package com.mycompany.test01.Common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Interface.FileChooserInterface;
import com.mycompany.test01.Interface.FileChooserListenerInterface;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import java.io.File;

public class DesktopMapFileChooser implements FileChooserInterface {
    @Override
    public void openLoadFileChooser(FileChooserListenerInterface listener, String dirPath) {
        JFileChooser chooser = new JFileChooser();
        File defaultDirectory = new File(Gdx.files.local(dirPath).file().getAbsolutePath());
        chooser.setCurrentDirectory(defaultDirectory);
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".json");
            }

            @Override
            public String getDescription() {
                return "JSON files (*.json)";
            }
        });
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            listener.selected(new FileHandle(selectedFile), "LOAD");
        } else {
            listener.cancellation();
        }
    }

    @Override
    public void openSaveFileChooser(FileChooserListenerInterface listener, String dirPath) {
        JFileChooser chooser = new JFileChooser();
        File defaultDirectory = new File(Gdx.files.local(dirPath).file().getAbsolutePath());
        chooser.setCurrentDirectory(defaultDirectory);
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".json");
            }

            @Override
            public String getDescription() {
                return "JSON files (*.json)";
            }
        });
        int returnVal = chooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            if (!selectedFile.getName().toLowerCase().endsWith(".json")) {
                selectedFile = new File(selectedFile.getAbsolutePath() + ".json");
            }
            listener.selected(new FileHandle(selectedFile), "SAVE");
        } else {
            listener.cancellation();
        }
    }
}
