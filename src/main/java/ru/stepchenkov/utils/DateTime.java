package ru.stepchenkov.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

    public static final DateTimeFormatter yyyy_MM_dd_T_HH_mm_ssSSS_Z = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    public static final DateTimeFormatter yyyy_MM_dd = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String currentDateTime(DateTimeFormatter formatter) {
        return LocalDateTime.now().format(formatter);
    }
}
