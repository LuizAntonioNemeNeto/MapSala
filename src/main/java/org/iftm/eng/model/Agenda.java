package org.iftm.eng.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Agenda implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idagenda;
	private Date dia;
	private Time hora;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Sala sala;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idprofessor", nullable = false)
    private Professor professor;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcurso", nullable = false)
    private Curso curso;

	public Agenda(int idagenda, Date dia, Time hora, Sala sala, Professor professor, Curso curso) {
		super();
		this.idagenda = idagenda;
		this.dia = dia;
		this.hora = hora;
		this.sala = sala;
		this.professor = professor;
		this.curso = curso;
	}

	public Agenda() {
		
	}

	public int getIdagenda() {
		return idagenda;
	}

	public Date getDia() {
		return dia;
	}

	public Time getHora() {
		return hora;
	}

	public Sala getSala() {
		return sala;
	}

	public Professor getProfessor() {
		return professor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setIdagenda(int idagenda) {
		this.idagenda = idagenda;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
}
