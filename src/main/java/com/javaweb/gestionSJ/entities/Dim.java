package com.javaweb.gestionSJ.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dims")
public class Dim implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4660034524450455959L;
	@Id
	private String code_dim;
	private String date_dim;
	private String desc_dim;
	private String etat_dim;
	
	
	public Dim() {
		super();
	}

	public Dim(String code_dim, String date_dim, String desc_dim, String etat_dim) {
		super();
		this.code_dim = code_dim;
		this.desc_dim = desc_dim;
		this.etat_dim = etat_dim;
		this.date_dim = date_dim;
	}
	
	

	public Dim(String code_dim, String desc_dim, String etat_dim) {
		super();
		this.code_dim = code_dim;
		this.desc_dim = desc_dim;
		this.etat_dim = etat_dim;
		
	}
	
	

	public String getDate_dim() {
		return date_dim;
	}

	public void setDate_dim(String date_dim) {
		this.date_dim = date_dim;
	}

	public String getCode_dim() {
		return code_dim;
	}

	public void setCode_dim(String code_dim) {
		this.code_dim = code_dim;
	}

	public String getDesc_dim() {
		return desc_dim;
	}

	public void setDesc_dim(String desc_dim) {
		this.desc_dim = desc_dim;
	}

	public String getEtat_dim() {
		return etat_dim;
	}

	public void setEtat_dim(String etat_dim) {
		this.etat_dim = etat_dim;
	}

	
	
	
}
