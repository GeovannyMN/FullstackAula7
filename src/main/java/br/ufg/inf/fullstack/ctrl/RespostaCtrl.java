package br.ufg.inf.fullstack.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.fullstack.ctrl.business.DisciplinaBusiness;
import br.ufg.inf.fullstack.ctrl.exception.DisciplinaException;
import br.ufg.inf.fullstack.model.entities.Disciplina;

@RestController
@RequestMapping(value="/resposta")
public class RespostaCtrl {
	
	@Autowired
	private DisciplinaBusiness business;
	
	@GetMapping
	public ResponseEntity<Disciplina> inicio(){
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Enviando uma mensagem para o cliente (Front-End)");
		Disciplina disciplina = null;
		try {
			disciplina = business.findById(2);
		} catch (DisciplinaException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Disciplina>(
				disciplina, 
				headers, 
				HttpStatus.OK);
	}
	

}
