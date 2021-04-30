package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.ctrl.exception.CursoException;
import br.ufg.inf.fullstack.model.entities.Curso;
import br.ufg.inf.fullstack.model.repositories.CursoRepository;

@Service
public class CursoBusiness {

    @Autowired
    private CursoRepository repository;

    public List<Curso> findAll() {
        return repository.findAll();
    }

    public Curso findById(Integer id) throws CursoException {
        Optional<Curso> retorno = repository.findById(id);
        if (retorno.isEmpty()) {
            throw new CursoException("0129");
        }
        return retorno.get();
    }

    public List<Curso> findByNnCurso(String str) {
        return repository.findByNmCurso(str);
    }

    public Curso insert(Curso Curso) throws CursoException {
        this.validarCurso(Curso);
        return repository.save(Curso);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Curso update(Curso Curso) throws CursoException {
        this.validarCurso(Curso);
        Curso CursoUpd = repository.findById(Curso.getIdCurso()).get();
        CursoUpd.setNmCurso(Curso.getNmCurso());
        return repository.save(CursoUpd);

    }

    private void validarCurso(Curso Curso) throws CursoException {
        if (Curso.getNmCurso() == null || Curso.getNmCurso().length() == 0) {
            throw new CursoException("0124");
        }
    }

}
