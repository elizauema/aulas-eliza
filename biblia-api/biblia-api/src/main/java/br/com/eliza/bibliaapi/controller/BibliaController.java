package br.com.eliza.bibliaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.eliza.bibliaapi.dto.saida.BibliaApiExibe;
import br.com.eliza.bibliaapi.service.ConsultaBibliaService;

@RestController
public class BibliaController {
	@Autowired
	ConsultaBibliaService consultaBibliaService;
	
	@GetMapping(value = "/livro/{nomeDoLivro}/capitulo/{numCapitulo}")
	public ResponseEntity<BibliaApiExibe> consultarPorLivroECapitulo(@PathVariable String nomeDoLivro, @PathVariable String numCapitulo){
		BibliaApiExibe bibliaApiExibe = consultaBibliaService.consultarBiblia(nomeDoLivro, numCapitulo);
		return new ResponseEntity<>(bibliaApiExibe, HttpStatus.OK);	
	}
	//criar outro endpoint que aceita nome do livro,capitulo e versiculo
	@GetMapping(value = "/livro/{nomeDoLivro}/capitulo/{numCapitulo}/versiculo/{numVersiculo}")
	public ResponseEntity<BibliaApiExibe> consultarPorLivroCapituloEVersiculo(@PathVariable String nomeDoLivro, @PathVariable String numCapitulo, @PathVariable String numVersiculo){
		BibliaApiExibe bibliaApiExibe = consultaBibliaService.consultarBibliaVersiculo(nomeDoLivro, numCapitulo, numVersiculo);
		return new ResponseEntity<>(bibliaApiExibe, HttpStatus.OK);
	}
	
	
}
