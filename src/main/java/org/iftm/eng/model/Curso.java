package org.iftm.eng.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

public class Curso implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer  idcurso;
    private String codcurso;
    private String descricao;
    private String periodo;
    
    
	public Curso(Integer idcurso, String codcurso, String descricao, String periodo) {
		super();
		this.idcurso = idcurso;
		this.codcurso = codcurso;
		this.descricao = descricao;
		this.periodo = periodo;
	}
	
	@OneToMany(mappedBy = "curso", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Agenda> agenda;
	
	public Curso() {
		
	}

	public Integer getIdcurso() {
		return idcurso;
	}
	public String getCodcurso() {
		return codcurso;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setIdcurso(Integer idcurso) {
		this.idcurso = idcurso;
	}
	public void setCodcurso(String codcurso) {
		this.codcurso = codcurso;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
}
