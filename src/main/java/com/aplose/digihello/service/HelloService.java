package com.aplose.digihello.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public String getSalutation() {
		return "Je suis la classe de service et je vous dis Bonjour";
	}
}
