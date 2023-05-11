package com.example.RestApiRJM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CAT_PERFIL")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})  
public class Perfil implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERFIL")
	private Integer idPerfil;
	@Column(name = "NOMBRE", length = 50)
	private String nombre;
	
	public Perfil(int id, String nombre) {
		this.idPerfil= id;
		this.nombre= nombre;
	}
	public Perfil() {}
	
	
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
