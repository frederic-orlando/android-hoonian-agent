package com.example.hoonianAgent.presenter.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class UtilsCurrency {
    public static final String toCurrency(int currency) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat format = NumberFormat.getCurrencyInstance(localeID);

        return format.format((double) currency);
    }
    public static final String toString(int currency) {
        String[] s = {"RB", "JT", "M", "T"};
        String string = String.valueOf(currency);
        int lengthZero = string.length() - 1;
        int divider = lengthZero / 3;
        int mod = lengthZero % 3;

        return string.substring(0, mod + 1) + " " + s[divider - 1];
    }
}
