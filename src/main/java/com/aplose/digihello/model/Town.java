package com.aplose.digihello.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Town {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer nbInhabitants;
	private Integer idRegion;
	@ManyToOne
	Department department;
	
	public Town() {}
	public Town(String name, Integer nbInhabitants) {
		super();
		this.name = name;
		this.nbInhabitants = nbInhabitants;
	}
	public Town(String name, Integer nbInhabitants,Department department) {
		super();
		this.name = name;
		this.nbInhabitants = nbInhabitants;
		this.department=department;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNbInhabitants() {
		return nbInhabitants;
	}
	public void setNbInhabitants(Integer nbInhabitants) {
		this.nbInhabitants = nbInhabitants;
	}
	public Integer getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	

}
