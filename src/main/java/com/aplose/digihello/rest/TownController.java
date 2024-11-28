package com.aplose.digihello.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aplose.digihello.dto.TownDto;
import com.aplose.digihello.mapper.TownMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplose.digihello.model.Town;
import com.aplose.digihello.service.TownService;

@RestController
@RequestMapping("/town")
public class TownController {
	@Autowired
	private TownService townService;

	private TownMapper townMapper = new TownMapper();

	@GetMapping
	public Iterable<TownDto> getTowns(){

		return townMapper.toDtos(townService.getAllTowns());
	}
	@GetMapping("/{id}")
	public TownDto getTown(@PathVariable("id") Long id) {
		return townMapper.toDto(townService.getTown(id).get());
	}
	@GetMapping("/name/{name}")
	public TownDto getTownByName(@PathVariable("name") String name) {
		return townMapper.toDto(townService.getTownByName(name));
	}
	@GetMapping("/nameStartingWith/{nameStart}")
	public Iterable<TownDto> getTownByNameStart(@PathVariable("nameStart") String nameStart) {
		return  townMapper.toDtos(townService.getTownByNameStart(nameStart));
	}
	@GetMapping("/findByNbInhabitantsGreaterThan/{min}")
	public Iterable<TownDto> getTownByNbInhabitantsGreaterThan(@PathVariable("min") Integer min) {
		return  townMapper.toDtos(townService.findByNbInhabitantsGreaterThan(min));
	}
	@GetMapping("/findByNbInhabitantsBetween/{min}/{max}")
	public Iterable<TownDto> findByNbInhabitantsBetween(@PathVariable("min") Integer min,@PathVariable("max") Integer max) {
		return  townMapper.toDtos(townService.findByNbInhabitantsBetween(min,max));
	}
	@GetMapping("/findByDepartmentCodeAndNbInhabitantsGreaterThan/{codeDep}/{min}")
	public Iterable<TownDto> findByDepartmentCodeAndNbInhabitantsGreaterThan(@PathVariable("codeDep")String codeDep, @PathVariable("min") Integer min) {
		return  townMapper.toDtos(townService.findByDepartmentCodeAndNbInhabitantsGreaterThan(codeDep,min));
	}
	@GetMapping("/findByDepartmentCodeAndNbInhabitantsBetween/{codeDep}/{min}/{max}")
	public Iterable<TownDto> findByDepartmentCodeAndNbInhabitantsBetween(@PathVariable("codeDep")String codeDep, @PathVariable("min") Integer min,@PathVariable("max") Integer max) {
		return  townMapper.toDtos(townService.findByDepartmentCodeAndNbInhabitantsBetween(codeDep, min,max));
	}
	@GetMapping("/findByDepartmentCodeOrderByNbInhabitantsDesc/{codeDep}/{size}")
	public Iterable<TownDto> findByDepartmentCodeOrderByNbInhabitantsDesc(@PathVariable("codeDep")String codeDep, @PathVariable("size") Integer size) {
		return  townMapper.toDtos(townService.findByDepartmentCodeOrderByNbInhabitantsDesc(codeDep,size));
	}
	
	@PostMapping
	public ResponseEntity<String> createTown(@RequestBody Town town) {
		if (townService.addTown(town)) {
			return new ResponseEntity<String>("Succès !",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Impossible de créer la ville, elle existe déjà ou il manque le département : "+town.toString(),HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping
	public ResponseEntity<String> updateTown(@RequestBody Town town) {
		if (townService.updateTown(town)) {
			return new ResponseEntity<String>("Succès !",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("La mise à jour a échouée !",HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTown(@PathVariable Long id) {
		if (townService.deleteTown(id)) {
			return new ResponseEntity<String>("Succès !",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("La supression a échouée !",HttpStatus.BAD_REQUEST);
		}
	}
	

}
