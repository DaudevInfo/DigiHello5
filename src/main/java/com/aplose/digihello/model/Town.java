package com.aplose.digihello.model;

public class Town {
	private static Long idCounter = 1L;
	private Long id;
	private String name;
	private Integer nbInhabitants;
	
	
	public Town(String name, Integer nbInhabitants) {
		super();
		this.name = name;
		this.nbInhabitants = nbInhabitants;
		this.id=idCounter++;
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

}
