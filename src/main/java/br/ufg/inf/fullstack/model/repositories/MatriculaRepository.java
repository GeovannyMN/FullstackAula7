package br.ufg.inf.fullstack.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fullstack.model.entities.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
    
}
