package com.javaweb.gestionSJ.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Requete")
public class Requete implements Serializable {
	
	@Id
	
	@Column(name="idReq")
	private String idReq;
	
	@Column(name="nomReq")
	private String nomReq;
	
	@Column(name="intitule")
	private String intitule;
	
	@Column(name="eltEntree")
	private String eltEntree;
	
	@Column(name="eltSortie")
	private String eltSortie;
	
	@Column(name="dateTraitement")
	private String dateTraitement;
	
	@Column(name="execution")
	private String execution;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Requete() {
		super();
	}
	public Requete(String idReq, String nomReq, String intitule, String eltEntree, String eltSortie,
			String dateTraitement, String execution) {
		super();
		this.idReq = idReq;
		this.nomReq = nomReq;
		this.intitule = intitule;
		this.eltEntree = eltEntree;
		this.eltSortie = eltSortie;
		this.dateTraitement = dateTraitement;
		this.execution = execution;
	}
	public String getIdReq() {
		return idReq;
	}
	public void setIdReq(String idReq) {
		this.idReq = idReq;
	}
	public String getNomReq() {
		return nomReq;
	}
	public void setNomReq(String nomReq) {
		this.nomReq = nomReq;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getEltEntree() {
		return eltEntree;
	}
	public void setEltEntree(String eltEntree) {
		this.eltEntree = eltEntree;
	}
	public String getEltSortie() {
		return eltSortie;
	}
	public void setEltSortie(String eltSortie) {
		this.eltSortie = eltSortie;
	}
	public String getDateTraitement() {
		return dateTraitement;
	}
	public void setDateTraitement(String dateTraitement) {
		this.dateTraitement = dateTraitement;
	}
	public String getExecution() {
		return execution;
	}
	public void setExecution(String execution) {
		this.execution = execution;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
