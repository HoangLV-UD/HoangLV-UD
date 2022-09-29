/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Pham Quoc Huy
 */
public class XDate {

    public static final SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
    private static SimpleDateFormat timestampFormater = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss a");

    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {

                formater.applyPattern(pattern[0]);

            }
            if (date == null) {
                return XDate.now();
            }
            System.out.println(date);
            return formater.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static Date toDate1(String date, String pattern) {
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            formater.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = XDate.now();
        }
        return formater.format(date);
    }

    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    public static Date now() {
        return new Date();
    }
    
}
