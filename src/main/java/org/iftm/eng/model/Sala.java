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


@Entity
public class Sala implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    private String numsala;
	private String tipo;
    private String capacidade;
    private String piso;
    
    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Agenda> agenda;
    
	public Sala() {
		
	}
	
	public Sala(int id, String numsala, String tipo, String capacidade, String piso) {
		super();
		this.id = id;
		this.numsala = numsala;
		this.tipo = tipo;
		this.capacidade = capacidade;
		this.piso = piso;
	}
	
	public int getId() {
		return id;
	}
	public String getNumsala() {
		return numsala;
	}
	public String getTipo() {
		return tipo;
	}
	public String getCapacidade() {
		return capacidade;
	}
	public String getPiso() {
		return piso;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNumsala(String numsala) {
		this.numsala = numsala;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
    
    

}
