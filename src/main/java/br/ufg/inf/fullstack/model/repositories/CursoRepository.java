package br.ufg.inf.fullstack.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufg.inf.fullstack.model.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

    @Query("SELECT d FROM Curso d WHERE d.nmCurso LIKE %:name%")
    public List<Curso> findByNmCurso(@Param("name") String name);
    
}
