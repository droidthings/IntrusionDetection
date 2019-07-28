package com.abi.rtes.utils;

import android.text.format.Time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Utils {

    public static String convertDate(String epochDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        sdf.setTimeZone(TimeZone.getTimeZone("CET"));
        String data = "";
        try {
            data=    dateFormat.format(sdf.parse(epochDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
return data;
    }
}
