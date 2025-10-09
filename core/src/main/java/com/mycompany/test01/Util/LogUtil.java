package com.mycompany.test01.Util;

public class LogUtil {
    public static void logError(String message, Exception e) {
        System.err.println("[ERROR] " + message);
        e.printStackTrace();
    }

    public static void logError(String message) {
        System.err.println("[ERROR] " + message);
    }

    public static void logWarning(String message) {
        System.out.println("[WARNING] " + message);
    }

    public static void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }
}
