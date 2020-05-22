package com.srik.limits.limitservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srik.limits.limitservices.bean.LimitConfiguration;

@RestController
public class LimitController {
	
	@Autowired
	private LimitConfigurationProperties limitConfigurationProperties;
	@GetMapping("/limits")
	public LimitConfiguration getLimits()
	{
	//	return new  LimitConfiguration(1000,1);
		// using limit config properties
		
		return new LimitConfiguration(limitConfigurationProperties.getMaxlimit(), limitConfigurationProperties.getMinlimit());
	}

}
