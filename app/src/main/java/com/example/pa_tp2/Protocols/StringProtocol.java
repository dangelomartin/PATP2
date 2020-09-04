package com.example.pa_tp2.Protocols;

public final class StringProtocol {
    public static String capitalize(String toCapital) {
        if (toCapital == null || toCapital.length() == 0) {
            return null;
        }

        return String.valueOf(toCapital.charAt(0)).toUpperCase() + toCapital.toLowerCase().substring(1);
    }
}
