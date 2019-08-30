package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallerController {
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${callee.host:callee.host:81}")
	String host;

	@GetMapping("/hello")
	public String hello() {
		return restTemplate.getForObject("http://" + host + "/hello", String.class);
	}

}