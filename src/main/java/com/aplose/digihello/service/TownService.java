package com.aplose.digihello.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aplose.digihello.model.Town;


@Service
public class TownService {
	
	private List<Town> towns = new ArrayList<>(Arrays.asList(new Town("Paris",2133111), new Town("Marseille", 873076), new Town("Lyon", 522250)));

	public List<Town> getAllTowns(){
		return this.towns;
	}
	
	public boolean addTown(Town town) {
		Town result = findTownByName(town.getName());
		if (result!=null) {
			return false;
		}
		this.towns.add(town);
		return true;
	}
	public boolean updateTown(Town town) {
		Town result = findTownById(town.getId());
		if (result!=null) {
			result.setName(town.getName());
			result.setNbInhabitants(town.getNbInhabitants());
			return true;
		}
		return false;
	}
	public boolean deleteTown(Long id) {
		Town result = findTownById(id);
		if (result!=null) {
			this.towns.remove(result);
			return true;
		}
		return false;
	}
	
	private Town findTownById(Long id) {
		Town result = this.towns.stream().filter(element -> id.equals(element.getId())).findAny().orElse(null);
		return result;
	}
	private Town findTownByName(String name) {
		Town result = this.towns.stream().filter(element -> name.equals(element.getName())).findAny().orElse(null);
		return result;
	}
	

}
