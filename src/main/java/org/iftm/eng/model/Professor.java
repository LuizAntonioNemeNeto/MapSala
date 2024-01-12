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
public class Professor implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idprofessor;
	
    private String codfun;
    private String nome;
    
    
	public Professor(Integer idprofessor, String codfun, String nome) {
		super();
		this.idprofessor = idprofessor;
		this.codfun = codfun;
		this.nome = nome;
	}
	
	@OneToMany(mappedBy = "professor", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Agenda> agenda;

	public Professor() {
		
	}


	public Integer getIdprofessor() {
		return idprofessor;
	}

	public String getCodfun() {
		return codfun;
	}

	public String getNome() {
		return nome;
	}
	public void setIdprofessor(Integer idprofessor) {
		this.idprofessor = idprofessor;
	}
	public void setCodfun(String codfun) {
		this.codfun = codfun;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    
    
}
