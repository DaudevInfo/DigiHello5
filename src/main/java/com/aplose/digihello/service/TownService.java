package com.aplose.digihello.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.aplose.digihello.exception.InvalidTownException;
import com.aplose.digihello.exception.TownNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aplose.digihello.model.Department;
import com.aplose.digihello.model.Town;
import com.aplose.digihello.repository.TownRepository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.NoResultException;


@Service
public class TownService {
	@Autowired
	TownRepository townRepository;
	@Autowired
	DepartmentService departmentService;
		
	public Iterable<Town> getAllTowns(){
		return townRepository.findAll();
	}
	
	public Optional<Town> getTown(Long id) {
		return townRepository.findById(id);
	}
	
	public Town getTownByName(String name) {		
		return townRepository.findByName(name);
	}
	
	public boolean addTown(Town town) {
		if (town.getNbInhabitants()< 10) {
			throw new InvalidTownException ("Town must have 10 inhabitants");
		}
		if (town.getName().length() < 2) {
			throw new InvalidTownException ("The name must contain two characters");
		}

		Town result = townRepository.findByName(town.getName());
		if (result!=null) {
			throw new InvalidTownException ("Town already exist");
		}else {
			townRepository.save(town);
			return true;
		}		
	}
	public boolean updateTown(Town town) {
			Optional<Town> result = townRepository.findById(town.getId());
			if (result.isEmpty()) {
				return false;
			}
			Town townToUpdate = result.get();
			townToUpdate.setName(town.getName());
			townRepository.save(townToUpdate);
			return true;
	}
	public boolean deleteTown(Long id) {
		Optional<Town> result = townRepository.findById(id);
		if (result.isEmpty()) {
			return false;
		}
		townRepository.deleteById(id);
		return true;
	}

	public Iterable<Town> getTownByNameStart(String nameStart) {
		List<Town> towns = townRepository.findByNameStartingWith(nameStart);
		if (towns.size() == 0) {
			throw new TownNotFound("No town begin with " + nameStart);
		}
		return towns;
	}

	public Iterable<Town> findByNbInhabitantsGreaterThan(Integer min) {

		List<Town> towns =  townRepository.findByNbInhabitantsGreaterThan(min);
		if (towns.size() == 0) {
			throw new TownNotFound("No town with more than " + min + " inhabitants");
		}
		return towns;
	}

	public Iterable<Town> findByNbInhabitantsBetween(Integer min, Integer max) {
		return townRepository.findByNbInhabitantsBetween(min, max);
	}
	
	public Iterable<Town> findByDepartmentCodeAndNbInhabitantsGreaterThan(String departmentCode, Integer min) {
		return townRepository.findByDepartmentCodeAndNbInhabitantsGreaterThan(departmentCode,min);
	}

	public Iterable<Town> findByDepartmentCodeAndNbInhabitantsBetween(String departmentCode, Integer min, Integer max) {
		return townRepository.findByDepartmentCodeAndNbInhabitantsBetween(departmentCode,min, max);
	}
	public Iterable<Town> findByDepartmentCodeOrderByNbInhabitantsDesc(String departmentCode, Integer size) {
		return townRepository.findByDepartmentCodeOrderByNbInhabitantsDesc(departmentCode,Pageable.ofSize(size)).getContent();
	}
	
}
