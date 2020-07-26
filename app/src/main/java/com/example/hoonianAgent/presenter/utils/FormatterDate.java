package com.example.hoonianAgent.presenter.utils;

import androidx.annotation.NonNull;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by AndreHF on 10/25/2016.
 */

public class FormatterDate {

    public final static String DD_MMM_YYYY = "dd MMM yyyy";
    public final static String TIME = "HH:mm";
    public final static Long defaultDate = 1262307600000L;

    public final static SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy",
            new Locale("in"));
    public final static SimpleDateFormat formatIndonesia = new SimpleDateFormat("dd-MMM-yyyy", new Locale("in"));
    public final static SimpleDateFormat formatWithTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat formatDateFullDay = new SimpleDateFormat("E, d MMM yyyy");
    public final static SimpleDateFormat formatTimeOnly = new SimpleDateFormat("HH:mm");

    public final static SimpleDateFormat formatDateTransaction = new SimpleDateFormat("d MMM yyyy");
    public final static SimpleDateFormat formatDateDMY = new SimpleDateFormat(DD_MMM_YYYY);

    public static final String changeString(String oldString, String newPattern) {
        return changeString(oldString, formatWithTime.toPattern(), newPattern);
    }

    public static final String changeString(String oldString, String oldPattern, String newPattern) {
        String result = "";
        SimpleDateFormat df = new SimpleDateFormat(oldPattern);

        if (oldString != null) {
            try {
                Date date = df.parse(oldString);
                df.applyPattern(newPattern);
                result = df.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static final String rangeTime(String startTime, String endTime) {
        String result = "";
        Date startDate, endDate;
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        try {
            startDate = df.parse(startTime);
            endDate = df.parse(endTime);

            df.applyPattern("HH.mm");

            result += df.format(startDate) + " - ";

            df.applyPattern("HH.mm a");
            result += df.format(endDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result.toLowerCase();
    }

    public static final Date stringToDate(String sDate) {
        Date date = new Date();
        if (sDate != null) {
            try {
                date = formatWithTime.parse(sDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public static final String changeDate(String sDate) {
        String result = "";
        if (sDate != null) {
            try {
                Date date = formatWithTime.parse(sDate);
                result = format.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static final long dateToLong(String sDate) {
        try {
            Date d = formatWithTime.parse(sDate);
            long milliseconds = d.getTime();
            return milliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static final String formatFullDateWithDay(@NonNull Date date) {
        if (date != null) {
            return formatDateFullDay.format(date);
        } else {
            return "";
        }
    }

    public static final long fullDateWithDayToLong(String sDate) {
        try {
            Date d = formatDateFullDay.parse(sDate);
            long milliseconds = d.getTime();
            return milliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Timestamp parseStringToTimeStamp(String strDate) {
        DateFormat format;
        format = new SimpleDateFormat("dd-MMM-yyyy", new Locale("in"));
        Date date = null;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp timestamp = null;
        if (date != null) {
            timestamp = new Timestamp(date.getTime());
        }
        return timestamp;
    }


    public static final String formatDate(long date) {
        date = date * 1000;
        return format.format(new Date(date));
    }

    public static final String formatDateTransaction(long date) {
        date = date * 1000;
        return formatDateTransaction.format(new Date(date));
    }

    public static final String formatDateTimeOnly(long date) {
        date = date * 1000;
        return formatTimeOnly.format(new Date(date));
    }

    public static final String formatDate(long date, String format) {
        date = date * 1000;
        SimpleDateFormat formatDate = new SimpleDateFormat(format,
                new Locale("in"));
        return formatDate.format(new Date(date));
    }

    public static final String formatHour(long date, String format) {
        SimpleDateFormat formatDate = new SimpleDateFormat(format,
                new Locale("in"));
        return formatDate.format(new Date(date));
    }

    public static final Timestamp nowDays() {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
        df.format(c);
        return new Timestamp(c.getTime());
    }

    public static final String formatTime(long timeStamp, String format) {
        Date time = new java.util.Date(timeStamp * 1000);
        SimpleDateFormat formatTime = new SimpleDateFormat(format,
                new Locale("in"));
        return formatTime.format(time);
    }

    public static final String formatTime(long timeStamp, SimpleDateFormat simpleDateFormat) {
        Date time = new java.util.Date(timeStamp * 1000);
        return simpleDateFormat.format(time);
    }
}
