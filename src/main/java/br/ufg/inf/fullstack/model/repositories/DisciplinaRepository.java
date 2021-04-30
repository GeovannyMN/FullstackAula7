package br.ufg.inf.fullstack.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufg.inf.fullstack.model.entities.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer>{

	@Query("SELECT d FROM Disciplina d WHERE d.nmDisciplina LIKE %:name%")
	public List<Disciplina> findByNmDisciplina(@Param("name") String name);
	
	@Query("SELECT d FROM Disciplina d WHERE d.cargaHoraria >= ?1")
	public List<Disciplina> findByCargaHorariaMaior(Integer ch);
}
