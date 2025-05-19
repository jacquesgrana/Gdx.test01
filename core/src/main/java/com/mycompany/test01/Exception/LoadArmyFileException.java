package com.mycompany.test01.Exception;

public class LoadArmyFileException extends Exception {
    public LoadArmyFileException(String message) {
        super(message);
    }

    public LoadArmyFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
