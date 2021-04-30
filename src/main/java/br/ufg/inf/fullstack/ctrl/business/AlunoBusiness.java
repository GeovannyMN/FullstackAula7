package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.ctrl.exception.AlunoException;
import br.ufg.inf.fullstack.model.entities.Aluno;
import br.ufg.inf.fullstack.model.repositories.AlunoRepository;

@Service
public class AlunoBusiness {

    @Autowired
    private AlunoRepository repository;

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Aluno findById(Integer id) throws AlunoException {
        Optional<Aluno> retorno = repository.findById(id);
        if (retorno.isEmpty()) {
            throw new AlunoException("0149");
        }
        return retorno.get();
    }

    /*
    public List<Aluno> findByIdPessoa (Integer v) {
        return repository.findByIdPessoa(v);
    }

    public List<Aluno> findByIdCurso(Integer v) {
        return repository.findByIdCurso(v);
    }
    */

    public Aluno insert(Aluno aluno) throws AlunoException {
        this.validarAluno(aluno);
        return repository.save(aluno);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Aluno update(Aluno aluno) throws AlunoException {
        this.validarAluno(aluno);
        Aluno alunoUpd = repository.findById(aluno.getIdAluno()).get();
        alunoUpd.setDtInicio(aluno.getDtInicio());
        alunoUpd.setAtivo(aluno.getAtivo());
        return repository.save(alunoUpd);

    }

    private void validarAluno(Aluno aluno) throws AlunoException {
        if (aluno.getAtivo().equals(false)) {
            throw new AlunoException("0143");
        }

        if (aluno.getIdAluno() >= 0) {
            throw new AlunoException("0149");
        }
    }

}
