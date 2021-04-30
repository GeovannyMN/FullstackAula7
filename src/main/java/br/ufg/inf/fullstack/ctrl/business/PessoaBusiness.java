package br.ufg.inf.fullstack.ctrl.business;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.ctrl.exception.PessoaException;
import br.ufg.inf.fullstack.model.entities.Pessoa;
import br.ufg.inf.fullstack.model.repositories.PessoaRepository;

@Service
public class PessoaBusiness {

	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll(){
		return repository.findAll();
	}
	
	public Pessoa findById(Integer id) throws PessoaException {
		Optional<Pessoa> retorno = repository.findById(id);
		if (retorno.isEmpty()) {
			throw new PessoaException("0169");
		}
		return retorno.get();
	}
	
	public Pessoa insert(Pessoa pessoa) throws PessoaException {
		this.validarPessoa(pessoa);
		return repository.save(pessoa);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Pessoa update(Pessoa pessoa) throws PessoaException {
		Pessoa pessoaUpd = repository.findById(pessoa.getIdPessoa()).get();
		this.validarPessoa(pessoa);
		pessoaUpd.setCpf(pessoa.getCpf());
		pessoaUpd.setNmPessoa(pessoa.getNmPessoa());
		pessoaUpd.setDtNascimento(pessoa.getDtNascimento());
		return repository.save(pessoaUpd);
		
	}

	public void validarPessoa(Pessoa pessoa) throws PessoaException{
		if (pessoa.getNmPessoa() == null || pessoa.getNmPessoa().length() == 0) {
			throw new PessoaException("0164");
		}
		Date hoje = new Date(System.currentTimeMillis());
		if (pessoa.getDtNascimento().before(hoje) ){
			throw new PessoaException("0163");
		}
	}
}
