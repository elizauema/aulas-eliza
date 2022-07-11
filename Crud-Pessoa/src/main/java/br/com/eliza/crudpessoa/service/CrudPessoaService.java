package br.com.eliza.crudpessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.eliza.crudpessoa.model.Pessoa;
import br.com.eliza.crudpessoa.repository.PessoaRepository;

@Service
public class CrudPessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa incluirPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa alterarPessoa(Pessoa pessoa, Long id) {
		Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
		if (pessoaOptional.isEmpty()) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		pessoa.setId(id);
		return pessoaRepository.save(pessoa);
	}
	
	public void excluirPessoa(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	public List<Pessoa> listarPessoa() {
		
		 return (List<Pessoa>) pessoaRepository.findAll();
		
	}
}


