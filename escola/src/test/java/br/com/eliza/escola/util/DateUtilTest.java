package br.com.eliza.escola.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;

import org.junit.jupiter.api.Test;

public class DateUtilTest {
	
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.getDefault())
		    .withResolverStyle(ResolverStyle.STRICT);
	
	@Test
	public void deveria_RetornarTrue_Quando_ADataEhValida() {
		boolean resultado = DateUtil.isValid("2021-08-26", dateFormatter);
		assertTrue(resultado);
	}
	
	@Test
	public void deveria_RetornarFalse_Quando_ADataEhInvalida() {
		boolean resultado = DateUtil.isValid("2021-02-29", dateFormatter);
		boolean resultado2 = DateUtil.isValid("2021-02-30", dateFormatter);
		boolean resultado3 = DateUtil.isValid("2021-50-40", dateFormatter);
		assertFalse(resultado);
		assertFalse(resultado2);
		assertFalse(resultado3);
	}
	
	@Test
	public void deveria_RetornarTrue_Quando_EhAnoBisexto() {
		boolean resultado = DateUtil.isValid("1992-02-29", dateFormatter);
		assertTrue(resultado);
	}

}
