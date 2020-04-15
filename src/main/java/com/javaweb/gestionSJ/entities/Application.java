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
@Table(name="Applications")
public class Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2103136134218612949L;
	@Id
	private String code_app;
	private String nom_app;
	
	
	
	@ManyToMany
	private Set<Direction> direction = new HashSet<>();
	
	@ManyToMany(mappedBy="application")
	private Collection<Incident> incident;
	
	
	
	public Set<Direction> getDirection() {
		return direction;
	}


	public void setIncident(Set<Incident> incident) {
		this.incident = incident;
	}





	public void setDirection(Set<Direction> direction) {
		this.direction = direction;
	}

	public Application() {
		super();
	}

	public Application(String codeApp, String nomApp) {
		super();
		this.code_app = codeApp;
		this.nom_app = nomApp;
	}

	
	
	public String getCode_app() {
		return code_app;
	}

	public void setCode_app(String code_app) {
		this.code_app = code_app;
	}

	public String getNom_app() {
		return nom_app;
	}

	public void setNom_app(String nom_app) {
		this.nom_app = nom_app;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
