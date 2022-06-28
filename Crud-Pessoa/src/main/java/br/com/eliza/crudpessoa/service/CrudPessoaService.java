package br.com.eliza.crudpessoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eliza.crudpessoa.model.Pessoa;
import br.com.eliza.crudpessoa.repository.PessoaRepository;

@Service
public class CrudPessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa incluirPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
}


