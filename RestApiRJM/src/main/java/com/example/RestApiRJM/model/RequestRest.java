package com.example.RestApiRJM.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class RequestRest implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private List<Map<String, String>> message;
	
	public RequestRest(String code, List<Map<String, String>> message) {
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Map<String, String>> getMessage() {
		return message;
	}
	public void setMessage(List<Map<String, String>> message) {
		this.message = message;
	}
	
	
	
	
	

}
