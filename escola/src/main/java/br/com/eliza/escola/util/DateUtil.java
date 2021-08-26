package br.com.eliza.escola.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
//import java.time.format.ResolverStyle;
//import java.util.Locale;

public class DateUtil {
	
    public static boolean isValid(String dateStr, DateTimeFormatter dateFormatter) {
        try {
            LocalDate.parse(dateStr, dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    /*public static void main(String[] args) {
    	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.getDefault())
    		    .withResolverStyle(ResolverStyle.STRICT);
    	System.out.println(DateUtil.isValid("2021-08-26", dateFormatter));
    	System.out.println(DateUtil.isValid("2021-02-29", dateFormatter));
    	System.out.println(DateUtil.isValid("2021-02-30", dateFormatter));
    	System.out.println(DateUtil.isValid("2021-50-40", dateFormatter));
    	System.out.println(DateUtil.isValid("1992-02-29", dateFormatter));
	}*/
}
