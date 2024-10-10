package com.aplose.digihello.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
	
//	@PostConstruct
	public void init() {	
		//first time we create some towns because db is empty...
//		townDAO.create(new Town("Paris",2133111,departmentService.findByCode("75")));
//		townDAO.create(new Town("Marseille", 873076,departmentService.findByCode("13")));
//		townDAO.create(new Town("Lyon", 522250,departmentService.findByCode("69")));
	}
	
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
		Town result = townRepository.findByName(town.getName());
		if (result!=null) {
			return false;
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
		return townRepository.findByNameStartingWith(nameStart);
	}

	public Iterable<Town> findByNbInhabitantsGreaterThan(Integer min) {
		return townRepository.findByNbInhabitantsGreaterThan(min);
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
