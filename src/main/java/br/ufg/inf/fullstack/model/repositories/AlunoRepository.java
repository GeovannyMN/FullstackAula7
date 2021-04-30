package br.ufg.inf.fullstack.model.repositories;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import br.ufg.inf.fullstack.model.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

        /*
        @Query("SELECT idAluno FROM Aluno a WHERE a.pessoa.idPessoa = id")
        public List<Aluno> findByIdPessoa(@Param("id") Integer id);

        @Query("SELECT idAluno FROM Aluno a WHERE a.curso.idCurso = id")
        public List<Aluno> findByIdCurso(@Param("name") Integer id );
        */
}
