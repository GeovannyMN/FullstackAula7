package br.ufg.inf.fullstack.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufg.inf.fullstack.model.enums.Dia;

@Entity
@Table(name="tb_oferta")
public class Oferta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_oferta")
	private Integer idOferta;
	
	@ManyToOne
	@JoinColumn(name="id_professor")
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name="id_displina")
	private Disciplina disciplina;
	
	@Column(name="dt_incio")
	private Date dtInicio;
	
	@Column(name="dt_fim")
	private Date dtFim;
	
	@Column(name="dia")
	private Dia dia;
	
	@Column(name="hora")
	private String hora;
	
	public Oferta() {
		super();
	}
	
	public Oferta(Integer idOferta, Professor professor, Disciplina disciplina, Date dtInicio, Date dtFim, Dia dia,
			String hora) {
		super();
		this.idOferta = idOferta;
		this.professor = professor;
		this.disciplina = disciplina;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
		this.dia = dia;
		this.hora = hora;
	}

	public Integer getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Integer idOferta) {
		this.idOferta = idOferta;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Oferta [idOferta=" + idOferta + ", professor=" + professor + ", disciplina=" + disciplina
				+ ", dtInicio=" + dtInicio + ", dtFim=" + dtFim + ", dia=" + dia + ", hora=" + hora + "]";
	}
	
}
