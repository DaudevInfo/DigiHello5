package com.aplose.digihello.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	

	@GetMapping
	public List<Town> getTowns(){
		return townService.getAllTowns();
	}
	@PostMapping
	public ResponseEntity<String> createTown(@RequestBody Town town) {
		if (townService.addTown(town)) {
			return new ResponseEntity<String>("Succès !",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("La ville existe déjà !",HttpStatus.BAD_REQUEST);
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
