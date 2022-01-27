package br.com.eliza.bibliaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BibliaController {
	@GetMapping(value = "/livro/{nomeDoLivro}/capitulo/{numCapitulo}")
	public ResponseEntity<String> consultarPorLivroECapitulo(@PathVariable String nomeDoLivro, @PathVariable String numCapitulo){
		System.out.println(nomeDoLivro + " " + numCapitulo);
		return new ResponseEntity<>("Fim da Consulta", HttpStatus.OK);	
	}
	

}
