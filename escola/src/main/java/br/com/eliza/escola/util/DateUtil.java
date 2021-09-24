package br.com.eliza.escola.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
//import java.time.format.ResolverStyle;
//import java.util.Locale;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class DateUtil {
	
    public static boolean isValid(String dateStr) {
        try {
        	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.getDefault())
					.withResolverStyle(ResolverStyle.STRICT);
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
    
    public static String formatarDataComHifen(String dataSemFormatacao) {
		return dataSemFormatacao.substring(4) + "-" + dataSemFormatacao.substring(2, 4) + "-" + dataSemFormatacao.substring(0, 2);
    }
    
    public static LocalDate criarLocalDate(String data) {
		
		int anoDma = Integer.parseInt(data.substring(4));
		int mesDma = Integer.parseInt(data.substring(2, 4));
		int diaDma = Integer.parseInt(data.substring(0, 2));
		
		return LocalDate.of(anoDma, Month.of(mesDma), diaDma);
    }
}
