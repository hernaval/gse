package com.javaweb.gestionSJ.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Directions")
public class Direction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6489977988227521091L;
	@Id
	private String code_dir;
	private String lib_dir;
	
	@ManyToMany(mappedBy="direction")
	private Set<Application> application = new HashSet<>();
	
	
	
	
	public Direction() {
		super();
	}
	
	@OneToMany(mappedBy="direction")
	private Collection<Activite> activite;

	public Direction(String code_dir, String lib_dir) {
		super();
		this.code_dir = code_dir;
		this.lib_dir = lib_dir;
	}

	public String getCode_dir() {
		return code_dir;
	}

	public void setCode_dir(String code_dir) {
		this.code_dir = code_dir;
	}

	public String getLib_dir() {
		return lib_dir;
	}

	public void setLib_dir(String lib_dir) {
		this.lib_dir = lib_dir;
	}
	
	
	
	
}
