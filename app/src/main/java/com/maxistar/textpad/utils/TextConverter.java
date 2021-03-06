package com.maxistar.textpad.utils;

public class TextConverter {

    private static final String RN = "\r\n";
    private static final String N = "\n";
    private static final String R = "\r";
    private static final String WINDOWS = "windows";
    public static final String UNIX = "unix";
    private static final String MACOS = "macos";

    static private TextConverter instance = null;

    public static TextConverter getInstance() {
        if (instance == null) {
            instance = new TextConverter();
        }
        return instance;
    }

    public String applyEndings(String value, String to) {

        if (WINDOWS.equals(to)) {
            value = value.replace(RN, N);
            value = value.replace(R, N);
            value = value.replace(N, RN); //simply replace unix endings to win endings
            return value;
        }

        if (UNIX.equals(to)) { //just in case it was previously read as other encoding
            value = value.replace(RN, N);
            value = value.replace(R, N);
            return value;
        }

        if (MACOS.equals(to)) {
            value = value.replace(RN, N);
            value = value.replace(R, N);
            value = value.replace(N, R); //simply replace unix endings to mac endings
            return value;
        }

        return value; //leave as is

    }
}
