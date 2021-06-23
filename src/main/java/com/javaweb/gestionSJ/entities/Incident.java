package com.javaweb.gestionSJ.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Incidents")
public class Incident implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6337334412278700516L;
	@Id
	private String code_inc;
	private String date_deb_inc;
	private String heure_deb_inc;
	private String date_fin_inc;
	private String heure_fin_inc;
	private String desc_inc;
	private String cause_inc;
	private String util_imp_inc;
	private String consequence_inc;
	private String sous_cat_risk;
	private String echeance;
	private int perte_interne;
	
	//clé étrangère
	
	
	@ManyToMany
	private Set<Application> application = new HashSet<>();
	

	public Set<Application> getApplication() {
		return application;
	}

	public void setApplication(Set<Application> application) {
		this.application = application;
	}

	public Incident() {
		super();
	}

	public Incident(String code_inc, String date_deb_inc, String heure_deb_inc, String date_fin_inc,
			String heure_fin_inc, String desc_inc, String cause_inc, String util_imp_inc, String consequence_inc,
			String sous_cat_risk,String echeance, int perte_interne) {
		super();
		this.code_inc = code_inc;
		this.date_deb_inc = date_deb_inc;
		this.heure_deb_inc = heure_deb_inc;
		this.date_fin_inc = date_fin_inc;
		this.heure_fin_inc = heure_fin_inc;
		this.desc_inc = desc_inc;
		this.cause_inc = cause_inc;
		this.util_imp_inc = util_imp_inc;
		this.consequence_inc = consequence_inc;
		this.sous_cat_risk = sous_cat_risk;
		this.echeance = echeance;
		this.perte_interne = perte_interne;
		
	}


	public String getCode_inc() {
		return code_inc;
	}

	public void setCode_inc(String code_inc) {
		this.code_inc = code_inc;
	}

	public String getDate_deb_inc() {
		return date_deb_inc;
	}

	public void setDate_deb_inc(String date_deb_inc) {
		this.date_deb_inc = date_deb_inc;
	}

	public String getHeure_deb_inc() {
		return heure_deb_inc;
	}

	public void setHeure_deb_inc(String heure_deb_inc) {
		this.heure_deb_inc = heure_deb_inc;
	}

	public String getUtil_imp_inc() {
		return util_imp_inc;
	}

	public void setUtil_imp_inc(String util_imp_inc) {
		this.util_imp_inc = util_imp_inc;
	}

	public String getConsequence_inc() {
		return consequence_inc;
	}

	public void setConsequence_inc(String consequence_inc) {
		this.consequence_inc = consequence_inc;
	}

	public String getSous_cat_risk() {
		return sous_cat_risk;
	}

	public void setSous_cat_risk(String sous_cat_risk) {
		this.sous_cat_risk = sous_cat_risk;
	}

	public String getCause_inc() {
		return cause_inc;
	}

	public void setCause_inc(String cause_inc) {
		this.cause_inc = cause_inc;
	}

	public String getDesc_inc() {
		return desc_inc;
	}

	public void setDesc_inc(String desc_inc) {
		this.desc_inc = desc_inc;
	}



	public int getPerte_interne() {
		return perte_interne;
	}



	public void setPerte_interne(int perte_interne) {
		this.perte_interne = perte_interne;
	}





	public String getDate_fin_inc() {
		return date_fin_inc;
	}





	public void setDate_fin_inc(String date_fin_inc) {
		this.date_fin_inc = date_fin_inc;
	}





	public String getHeure_fin_inc() {
		return heure_fin_inc;
	}





	public void setHeure_fin_inc(String heure_fin_inc) {
		this.heure_fin_inc = heure_fin_inc;
	}

	public String getEcheance() {
		return echeance;
	}

	public void setEcheance(String echeance) {
		this.echeance = echeance;
	}
	
	
	
	
}
