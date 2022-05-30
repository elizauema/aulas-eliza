package br.com.eliza.alexa;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.Assert;

public class CasaAutomatizadaTest {

	@Test
	public void test() {
		// Alexa m = Mockito.mock(Alexa.class); qdo nao tem o import static mockito
		Alexa m = mock(Alexa.class);
		when(m.perguntar(anyString())).thenReturn("Estou bem");
		
		CasaAutomatizada casa = new CasaAutomatizada(m);
		String resposta = casa.perguntarParaAlexa("Como vai voce");
		Assert.assertEquals("Estou bem", resposta);
	}

}
