package com.srik.limits.limitservices;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * to fetch limits from application properties 
 * with reference of application name
 */
@Component  // in order to access externally as bean
@ConfigurationProperties("limit-service")  // start tag of keys in application properties are fed as reference
public class LimitConfigurationProperties {

	private int minlimit;
	private int maxlimit;
	public int getMinlimit() {
		return minlimit;
	}
	public void setMinlimit(int minlimit) {
		this.minlimit = minlimit;
	}
	public int getMaxlimit() {
		return maxlimit;
	}
	public void setMaxlimit(int maxlimit) {
		this.maxlimit = maxlimit;
	}
	public LimitConfigurationProperties() {
		super();
	}
	public LimitConfigurationProperties(int minlimit, int maxlimit) {
		super();
		this.minlimit = minlimit;
		this.maxlimit = maxlimit;
	}
	
	
	
}
