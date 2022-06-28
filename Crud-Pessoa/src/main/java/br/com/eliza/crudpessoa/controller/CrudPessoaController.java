package br.com.eliza.crudpessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.eliza.crudpessoa.model.Pessoa;
import br.com.eliza.crudpessoa.service.CrudPessoaService;

@RestController
public class CrudPessoaController {
	@Autowired
	CrudPessoaService crudPessoaService;
	
	@PostMapping("/pessoas")
	public ResponseEntity<Pessoa> incluir(@RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = crudPessoaService.incluirPessoa(pessoa);
		return new ResponseEntity<>(pessoaSalva, HttpStatus.CREATED);
	}
		
	public void alterar() {
		
	}
	
	public void excluir(){
		
	}
	
}
