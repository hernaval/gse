package com.javaweb.gestionSJ.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Responsables")
public class Responsable implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7779743995446222861L;
	@Id
	private String code_resp;
	private String nom_resp;
	private String prenom_resp;
	private String username;
	private String password;
	private String role;
	

	@OneToMany(mappedBy="responsable")
	private Collection<Activite> activite;
	
	@OneToMany(mappedBy="editeur")
	private Collection<Activite> activiteEdit;
	
	public Responsable(){
		super();
	}
	
	
	public Responsable(String code_resp, String nom_resp, String prenom_resp, String username, String password,
			String role, Collection<Activite> activite) {
		super();
		this.code_resp = code_resp;
		this.nom_resp = nom_resp;
		this.prenom_resp = prenom_resp;
		this.username = username;
		this.password = password;
		this.role = role;
		this.activite = activite;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getCode_resp() {
		return code_resp;
	}
	public void setCode_resp(String code_resp) {
		this.code_resp = code_resp;
	}
	public String getNom_resp() {
		return nom_resp;
	}
	public void setNom_resp(String nom_resp) {
		this.nom_resp = nom_resp;
	}



	public String getPrenom_resp() {
		return prenom_resp;
	}



	public void setPrenom_resp(String prenom_resp) {
		this.prenom_resp = prenom_resp;
	}
	
	
}
