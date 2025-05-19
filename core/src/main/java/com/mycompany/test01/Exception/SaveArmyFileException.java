package com.mycompany.test01.Exception;

public class SaveArmyFileException extends Exception {
    public SaveArmyFileException(String message) {
        super(message);
    }

    public SaveArmyFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
