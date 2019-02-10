package com.luv2code;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

  private DateUtils() {}

  // read a date string and parse/convert to a date
  public static Date parseDate(String dateStr) throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    return formatter.parse(dateStr);
  }

  // read a date and format/convert to a string
  public static String formatDate(Date theDate) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String result = null;
    if (theDate != null) {
      result = formatter.format(theDate);
    }
    return result;
  }
}
