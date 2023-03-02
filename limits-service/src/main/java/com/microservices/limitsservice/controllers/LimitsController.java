package com.microservices.limitsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitsservice.bean.Limits;
import com.microservices.limitsservice.configuration.Configuration;


@RestController
public class LimitsController {
	
	@Autowired
	private Configuration configuration;
	
	public LimitsController(final Configuration configuration) {
		this.configuration = configuration;
	}
	
	@GetMapping("/limits")
	public Limits retreiveLimits() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
	}
}
