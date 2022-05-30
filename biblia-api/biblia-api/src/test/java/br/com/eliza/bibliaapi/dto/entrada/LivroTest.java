package br.com.eliza.bibliaapi.dto.entrada;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class LivroTest {
	Livro livro;
	
	@Before
	public void inicializar() {
		livro = new Livro();
		livro.setNome("Números");
		livro.setAutor("Moisés");
		livro.setGrupo("Pentateuco");
		livro.setTraducao("Português");
		livro.setAbreviacao(new Abreviacao());   
		
	}
	@Test
	public void testarGettersESetters(){
		assertEquals("Números", livro.getNome());
		assertEquals("Moisés", livro.getAutor());
		assertEquals("Pentateuco", livro.getGrupo());
		assertEquals("Português", livro.getTraducao());
		assertNotNull(livro.getAbreviacao());
	}
	@Test
	public void testarToString() {
		//System.out.println(livro.toString());
		assertEquals("Livro [nome=Números, autor=Moisés, grupo=Pentateuco, traducao=Português, abreviacao=Abreviacao [pt=null, en=null]]", livro.toString());
	}
}
