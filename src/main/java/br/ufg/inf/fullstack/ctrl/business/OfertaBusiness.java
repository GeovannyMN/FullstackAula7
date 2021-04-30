package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.ctrl.exception.OfertaException;
import br.ufg.inf.fullstack.model.entities.Oferta;
import br.ufg.inf.fullstack.model.repositories.OfertaRepository;

@Service
public class OfertaBusiness {

	@Autowired
	private OfertaRepository repository;

	public List<Oferta> findAll() {
		return repository.findAll();
	}

	public Oferta findById(Integer id) throws OfertaException {
		Optional<Oferta> retorno = repository.findById(id);
		if (retorno.isEmpty()) {
			throw new OfertaException("0159");
		}
		return retorno.get();
	}

	public Oferta insert(Oferta oferta) throws OfertaException {
		this.validarOferta(oferta);
		return repository.save(oferta);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Oferta update(Oferta ofertaUpd) throws OfertaException {
		Oferta oferta = repository.findById(ofertaUpd.getIdOferta()).get();
		this.validarOferta(oferta);
		oferta.setDia(ofertaUpd.getDia());
		oferta.setDisciplina(ofertaUpd.getDisciplina());
		oferta.setDtFim(ofertaUpd.getDtFim());
		oferta.setDtInicio(ofertaUpd.getDtInicio());
		oferta.setHora(ofertaUpd.getHora());
		oferta.setProfessor(ofertaUpd.getProfessor());
		return repository.save(oferta);

	}

	private void validarOferta (Oferta oferta) throws OfertaException {
		if ( oferta.getDtInicio().after( oferta.getDtFim() ) ){
			throw new OfertaException("0143");
		}
		if ( oferta.getDtInicio().equals( oferta.getDtFim() ) ) {
			throw new OfertaException("0143");
		}
	}
}
