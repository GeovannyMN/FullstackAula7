package br.ufg.inf.fullstack.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fullstack.model.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
