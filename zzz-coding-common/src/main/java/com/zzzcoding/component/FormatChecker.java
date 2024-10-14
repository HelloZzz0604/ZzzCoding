package com.zzzcoding.component;

import java.util.regex.Pattern;

public class FormatChecker {
    public static boolean isValidEmail(String email) {
        if ((email != null) && (!email.trim().isEmpty())) {
            return Pattern.matches("^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$", email);
        }

        return false;
    }

}
