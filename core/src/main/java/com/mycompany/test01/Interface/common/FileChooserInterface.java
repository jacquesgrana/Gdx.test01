package com.mycompany.test01.Interface.common;

public interface FileChooserInterface {
    void openLoadFileChooser(FileChooserListenerInterface listener, String dirPath);
    void openSaveFileChooser(FileChooserListenerInterface listener, String dirPath);
}
