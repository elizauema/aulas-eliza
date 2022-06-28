package br.com.eliza.crudpessoa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.eliza.crudpessoa.model.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
	
}
