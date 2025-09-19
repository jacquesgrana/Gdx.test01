package com.mycompany.test01.Interface.common;

import com.badlogic.gdx.files.FileHandle;

public interface FileChooserListenerInterface {
    void selected(FileHandle file, String mode);
    void cancellation();
}
