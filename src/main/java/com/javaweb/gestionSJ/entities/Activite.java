package com.javaweb.gestionSJ.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Activites")
public class Activite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1052835869738253597L;
	@Id
	private String code_act;
	private String date_act;
	private String object_act;
	private String type_dmd;
	private String caract_act;
	private String etat_act;
	private String data_liv_act;
	private String obs_act;
	
	//clé étrangère

	@ManyToOne
	private Responsable responsable;
	
	@ManyToOne
	private Responsable editeur;
	
	@ManyToOne
	private Direction direction;
	

	@OneToMany(mappedBy="activite")
	private Collection<FaitMarquant> faitmarquant;
	
	
	
	public Responsable getEditeur() {
		return editeur;
	}

	public void setEditeur(Responsable editeur) {
		this.editeur = editeur;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	
	public Activite() {
		super();
	}

	public Activite(String code_act, String date_act, String object_act, String type_dmd, String caract_act,
			String etat_act, String data_liv_act, String obs_act, Responsable responsable, Responsable editeur,
			Direction direction, Collection<FaitMarquant> faitmarquant) {
		super();
		this.code_act = code_act;
		this.date_act = date_act;
		this.object_act = object_act;
		this.type_dmd = type_dmd;
		this.caract_act = caract_act;
		this.etat_act = etat_act;
		this.data_liv_act = data_liv_act;
		this.obs_act = obs_act;
		this.responsable = responsable;
		this.editeur = editeur;
		this.direction = direction;
		this.faitmarquant = faitmarquant;
	}

	public String getCode_act() {
		return code_act;
	}

	public void setCode_act(String code_act) {
		this.code_act = code_act;
	}

	public String getDate_act() {
		return date_act;
	}

	public void setDate_act(String date_act) {
		this.date_act = date_act;
	}

	public String getObject_act() {
		return object_act;
	}

	public void setObject_act(String object_act) {
		this.object_act = object_act;
	}

	public String getType_dmd() {
		return type_dmd;
	}

	public void setType_dmd(String type_dmd) {
		this.type_dmd = type_dmd;
	}

	
	public String getEtat_act() {
		return etat_act;
	}

	public void setEtat_act(String etat_act) {
		this.etat_act = etat_act;
	}

	public String getData_liv_act() {
		return data_liv_act;
	}

	public void setData_liv_act(String data_liv_act) {
		this.data_liv_act = data_liv_act;
	}

	
	public String getObs_act() {
		return obs_act;
	}

	public void setObs_act(String obs_act) {
		this.obs_act = obs_act;
	}

	public String getCaract_act() {
		return caract_act;
	}

	public void setCaract_act(String caract_act) {
		this.caract_act = caract_act;
	}
	
	
	
	
}
