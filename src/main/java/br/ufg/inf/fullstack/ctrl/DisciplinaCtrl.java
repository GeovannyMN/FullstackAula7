package br.ufg.inf.fullstack.ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.fullstack.ctrl.business.DisciplinaBusiness;
import br.ufg.inf.fullstack.ctrl.exception.DisciplinaException;
import br.ufg.inf.fullstack.model.entities.Disciplina;
import br.ufg.inf.fullstack.util.Message;

@RestController
@RequestMapping(value="/disciplinas")
public class DisciplinaCtrl {
	
	@Autowired
	private DisciplinaBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Disciplina>> findAll() {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		List<Disciplina> list = business.findAll();
		if(list.size() == 0) {
			status = HttpStatus.NO_CONTENT;
			headers.add("message", Message.get("0111"));
		}
		return new ResponseEntity<List<Disciplina>>(list, headers, status);
	}
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Disciplina> findById(@PathVariable Integer id){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		Disciplina retorno = new Disciplina();
		try {
			retorno = business.findById(id);
		} catch (DisciplinaException e) {
			headers.add("message", Message.get(e.getMessage()));
			status = HttpStatus.NO_CONTENT;
		} catch (Exception e) {
			headers.add("message", Message.get("0002"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Disciplina>(retorno, headers, status);
	}
	

	@GetMapping(value="/find/{str}")
	public ResponseEntity<List<Disciplina>> findByName(@PathVariable Optional<String> str){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		List<Disciplina> list = business.findByNnDisciplina(str.get()); 
		if(list.size() == 0) {
			status = HttpStatus.NO_CONTENT;
			headers.add("message", Message.get("0111"));
		}
		return new ResponseEntity<List<Disciplina>>(list, headers, status);
	}
	
	

	@GetMapping(value="/cargaHorariaMaior/{v}")
	public ResponseEntity<List<Disciplina>> cargaHorariaMaior(@PathVariable Integer v){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		List<Disciplina> list = business.findCargaHorariaMaior(v);
		if(list.size() == 0) {
			status = HttpStatus.NO_CONTENT;
			headers.add("message", Message.get("0110"));
		}
		return new ResponseEntity<List<Disciplina>>(list, headers, status);
	}
	
	@PostMapping
	public ResponseEntity<Disciplina> insert(@RequestBody Disciplina disciplina){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
	
		try {
			disciplina = business.insert(disciplina);
			headers.add("message", Message.get("0101"));
		} catch (DisciplinaException e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Message.get(e.getMessage()));
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers.add("message", Message.get("0102"));
		}
	
		return new ResponseEntity<Disciplina>(disciplina, headers, status);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		try {
			business.delete(id);
			headers.add("message", Message.get("0107"));
		}catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers.add("message", Message.get("0108"));
		}
		return new ResponseEntity<Void>(null, headers, status);
	}
	
	@PutMapping
	public ResponseEntity<Disciplina> update(@RequestBody Disciplina disciplina){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			disciplina = business.insert(disciplina);
			headers.add("message", Message.get("0105"));
		} catch (DisciplinaException e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Message.get(e.getMessage()));			
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers.add("message", Message.get("0106"));	
		}
		return new ResponseEntity<Disciplina>(disciplina, headers, status);
	}
	
}
