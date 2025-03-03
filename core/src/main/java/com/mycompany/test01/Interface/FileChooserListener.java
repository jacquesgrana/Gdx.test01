package com.mycompany.test01.Interface;

import com.badlogic.gdx.files.FileHandle;

public interface FileChooserListener {
    void selected(FileHandle file, String mode);
    void cancellation();
}
