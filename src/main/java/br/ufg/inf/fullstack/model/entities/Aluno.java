package br.ufg.inf.fullstack.model.entities;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private Integer idAluno;

	@Column(name = "dt_inicio")
	private Date dtInicio;

	@Column(name = "ativo")
	private Boolean ativo;

	@JoinColumn(name = "pessoa")
	private Pessoa pessoa;

	@JoinColumn(name = "curso")
	private Curso curso;

	public Aluno() {
		super();
	}

	public Aluno(Integer idAluno, Date dtInicio, Boolean ativo, Pessoa pessoa, Curso curso) {
		super();
		this.idAluno = idAluno;
		this.dtInicio = dtInicio;
		this.ativo = ativo;
		this.pessoa = pessoa;
		this.curso = curso;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", dtInicio=" + dtInicio + ", ativo=" + ativo + ", pessoa=" + pessoa
				+ ", curso=" + curso + "]";
	}

}
