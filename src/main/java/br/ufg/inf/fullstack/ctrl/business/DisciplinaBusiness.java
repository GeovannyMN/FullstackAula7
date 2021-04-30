package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.ctrl.exception.DisciplinaException;
import br.ufg.inf.fullstack.model.entities.Disciplina;
import br.ufg.inf.fullstack.model.repositories.DisciplinaRepository;

@Service
public class DisciplinaBusiness {

	@Autowired
	private DisciplinaRepository repository;
	
	public List<Disciplina> findAll(){
		return repository.findAll();
	}
	
	public Disciplina findById(Integer id) throws DisciplinaException {
		Optional<Disciplina> retorno = repository.findById(id);
		if(retorno.isEmpty()) {
			throw new DisciplinaException("0109");
		}
		return retorno.get();
	}
	
	public List<Disciplina> findByNnDisciplina(String str){
		return repository.findByNmDisciplina(str);
	}
	
	public List<Disciplina> findCargaHorariaMaior(Integer v){
		return repository.findByCargaHorariaMaior(v);
	}
	
	public Disciplina insert(Disciplina disciplina) throws DisciplinaException {
		this.validarDisciplina(disciplina);
		return repository.save(disciplina);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Disciplina update(Disciplina disciplina) throws DisciplinaException {
		this.validarDisciplina(disciplina);
		Disciplina disciplinaUpd = repository.findById(disciplina.getIdDisciplina()).get();
		disciplinaUpd.setCargaHoraria(disciplina.getCargaHoraria());
		disciplinaUpd.setNmDisciplina(disciplina.getNmDisciplina());
		return repository.save(disciplinaUpd);
		
	}
	
	private void validarDisciplina(Disciplina disciplina) throws DisciplinaException {
		if (disciplina.getCargaHoraria() <= 0) {
			throw new DisciplinaException("0103");
		}

		if (disciplina.getNmDisciplina() == null || disciplina.getNmDisciplina().length() == 0) {
			throw new DisciplinaException("0104");
		}
	}
	
}
