package br.ufg.inf.fullstack.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fullstack.model.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
