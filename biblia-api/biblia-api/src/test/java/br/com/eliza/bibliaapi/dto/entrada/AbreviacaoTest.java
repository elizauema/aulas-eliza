package br.com.eliza.bibliaapi.dto.entrada;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AbreviacaoTest {
	Abreviacao abreviacao;
	
	@Before
	public void inicializar() {
		abreviacao = new Abreviacao();
		abreviacao.setPt("nm");
		abreviacao.setEn("nm");
	}
	
	@Test
	public void testarGettersESetters() {
		assertEquals("nm", abreviacao.getPt());
		assertEquals("nm", abreviacao.getEn());
	}
	
	@Test
	public void deveTestarToString() {
		assertEquals("Abreviacao [pt=nm, en=nm]",abreviacao.toString());
		
	}
}
