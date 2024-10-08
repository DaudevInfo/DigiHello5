package com.aplose.digihello.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplose.digihello.model.Town;

@RestController
@RequestMapping("/town")
public class TownController {
	private List<Town> towns = new ArrayList<>(Arrays.asList(new Town("Paris",2133111), new Town("Marseille", 873076), new Town("Lyon", 522250)));

	@GetMapping
	public List<Town> getTowns(){
		return towns;
	}
}
