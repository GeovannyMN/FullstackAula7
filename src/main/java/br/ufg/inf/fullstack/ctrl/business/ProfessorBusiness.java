package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.ctrl.exception.ProfessorException;
import br.ufg.inf.fullstack.model.entities.Professor;
import br.ufg.inf.fullstack.model.enums.Escolaridade;
import br.ufg.inf.fullstack.model.repositories.ProfessorRepository;

@Service
public class ProfessorBusiness {

	@Autowired
	private ProfessorRepository repository;
	
	public List<Professor> findAll(){
		return repository.findAll();
	}
	
	public Professor findById(Integer id) throws ProfessorException {
		Optional<Professor> retorno = repository.findById(id);
		if (retorno.isEmpty()) {
			throw new ProfessorException("0189");
		}
		return retorno.get();
	}
	
	public Professor insert(Professor professor) throws ProfessorException {
		this.validarProfessor(professor);
		return repository.save(professor);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Professor update(Professor professorUpd) throws ProfessorException {
		Professor professor = repository.findById(professorUpd.getIdProfessor()).get();
		this.validarProfessor(professor);
		professor.setEscolaridade(professorUpd.getEscolaridade());
		professor.setPessoa(professorUpd.getPessoa());
		return repository.save(professor);
	}

	public void validarProfessor(Professor professor) throws ProfessorException {
		if (professor.getIdProfessor() <= 0){
			throw new ProfessorException("183");
		}
		if (professor.getEscolaridade().equals(Escolaridade.MEDIO))
		{
			throw new ProfessorException("184");
		}
	}
}
