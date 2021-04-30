package br.ufg.inf.fullstack.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_disciplina")
public class Disciplina implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_disciplina")
	private Integer idDisciplina;
	
	@Column(name="nm_disciplina")
	private String nmDisciplina;
	
	@Column(name="carga_horaria")
	private Integer cargaHoraria;

	public Disciplina() {
		super();
	}

	public Disciplina(Integer idDisciplina, String nmDisciplina, Integer cargaHoraria) {
		super();
		this.idDisciplina = idDisciplina;
		this.nmDisciplina = nmDisciplina;
		this.cargaHoraria = cargaHoraria;
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNmDisciplina() {
		return nmDisciplina;
	}

	public void setNmDisciplina(String nmDisciplina) {
		this.nmDisciplina = nmDisciplina;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", nmDisciplina=" + nmDisciplina + ", cargaHoraria="
				+ cargaHoraria + "]";
	}

}
