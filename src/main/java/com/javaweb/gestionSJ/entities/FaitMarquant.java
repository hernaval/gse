package com.javaweb.gestionSJ.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FaitMarquants")
public class FaitMarquant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2340782641050328959L;
	@Id
	private String code_fmq;
	private String desc_fmq;
	private String date_liv_fmq;
	private String date_prod_fmq;
	//clé étrangère
	
	
	@ManyToOne
	private Activite activite;
	
	public FaitMarquant() {
		super();
	}

	
	
	public Activite getActivite() {
		return activite;
	}



	public void setActivite(Activite activite) {
		this.activite = activite;
	}



	public String getCode_fmq() {
		return code_fmq;
	}

	public void setCode_fmq(String code_fmq) {
		this.code_fmq = code_fmq;
	}

	public String getDesc_fmq() {
		return desc_fmq;
	}

	public void setDesc_fmq(String desc_fmq) {
		this.desc_fmq = desc_fmq;
	}


	public String getDate_liv_fmq() {
		return date_liv_fmq;
	}

	public void setDate_liv_fmq(String date_liv_fmq) {
		this.date_liv_fmq = date_liv_fmq;
	}

	public String getDate_prod_fmq() {
		return date_prod_fmq;
	}

	public void setDate_prod_fmq(String date_prod_fmq) {
		this.date_prod_fmq = date_prod_fmq;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
