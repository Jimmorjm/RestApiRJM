package com.example.RestApiRJM.vo;

import java.io.Serializable;
import java.util.HashMap;

public class ResponseFujoDinamico implements Serializable{
	
	private Integer idFlujo;
	private Integer statusReponse;
	private String messageResponse;
	private HashMap<String, Object> mapValuesResponse;
	
	public Integer getIdFlujo() {
		return idFlujo;
	}
	public void setIdFlujo(Integer idFlujo) {
		this.idFlujo = idFlujo;
	}
	public Integer getStatusReponse() {
		return statusReponse;
	}
	public void setStatusReponse(Integer statusReponse) {
		this.statusReponse = statusReponse;
	}
	public String getMessageResponse() {
		return messageResponse;
	}
	public void setMessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}
	public HashMap<String, Object> getMapValuesResponse() {
		return mapValuesResponse;
	}
	public void setMapValuesResponse(HashMap<String, Object> mapValuesResponse) {
		this.mapValuesResponse = mapValuesResponse;
	}
	
}
