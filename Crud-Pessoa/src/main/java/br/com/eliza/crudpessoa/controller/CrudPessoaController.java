package br.com.eliza.crudpessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PutMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> alterar(@RequestBody Pessoa pessoa, @PathVariable("id") Long id) {
		Pessoa pessoaSalva = crudPessoaService.alterarPessoa(pessoa, id);
		ResponseEntity<Pessoa> re = new ResponseEntity<>(pessoaSalva, HttpStatus.ACCEPTED);
		return re;
	}

	@DeleteMapping("/pessoas/{id}")
	public String excluir(@PathVariable("id") Long id) {
		crudPessoaService.excluirPessoa(id);
		return "Deletado com Sucesso";
	}

	@GetMapping("/pessoas")
	public List<Pessoa> listarPessoa() {
		List lista = crudPessoaService.listarPessoa();
		return lista;
	} 

}
