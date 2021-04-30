package br.ufg.inf.fullstack.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.ufg.inf.fullstack.model.enums.Escolaridade;

@Entity
@Table(name="tb_professor")
public class Professor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_professor")
	private Integer idProfessor;
	
	@OneToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	@Enumerated(EnumType.ORDINAL)
	private Escolaridade escolaridade;

	public Professor() {
		super();
	}

	public Professor(Integer idProfessor, Pessoa pessoa, Escolaridade escolaridade) {
		super();
		this.idProfessor = idProfessor;
		this.pessoa = pessoa;
		this.escolaridade = escolaridade;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	@Override
	public String toString() {
		return "Professor [idProfessor=" + idProfessor + ", pessoa=" + pessoa + ", escolaridade="
				+ escolaridade.getValue() + "]";
	}

}
