package com.mycompany.test01.Interface;

public interface FileChooser {
    void openLoadFileChooser(FileChooserListener listener, String dirPath);
    void openSaveFileChooser(FileChooserListener listener, String dirPath);
}
