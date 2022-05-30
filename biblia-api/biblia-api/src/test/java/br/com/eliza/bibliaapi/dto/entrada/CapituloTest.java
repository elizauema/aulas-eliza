package br.com.eliza.bibliaapi.dto.entrada;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CapituloTest {
	Capitulo capitulo;
	
	@Before
	public void inicializar() {
		capitulo = new Capitulo();
		capitulo.setNumero(36);
		capitulo.setQtdeVerso(13);
	}
	
	@Test
	public void testarGettersESetters() {
		assertEquals(36, capitulo.getNumero());
		assertEquals(13,capitulo.getQtdeVerso());
	}
	
	@Test
	public void testarToString() {
		//System.out.println(capitulo.toString());
		assertEquals("Capitulo [numero=36, qtdeVerso=13]", capitulo.toString());
	}
}
