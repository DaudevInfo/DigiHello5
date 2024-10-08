package com.aplose.digihello.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplose.digihello.service.HelloService;

/**
 * 
 */
@RestController
@RequestMapping("/hello")
public class HelloRestController {
	
	@Autowired
	HelloService helloService;


	/**
	 * Méthode de salutation
	 * @return Le bonjour à tout le monde
	 */
	@GetMapping
	public String sayHello() {
		return helloService.getSalutation();
	}
}
