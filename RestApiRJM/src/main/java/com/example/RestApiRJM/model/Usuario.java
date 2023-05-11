package com.example.RestApiRJM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ENT_USUARIOS")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})  
public class Usuario  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Integer idUsuario;
	@NotEmpty(message = "El nombre no puedo ir vacio")
	@Column(name = "NOMBRE")
	private String nombre;
	@NotEmpty(message = "El epellido no puedo ir vacio")
	@Column(name ="APELLIDOS" )
	private String apellido;
	@NotNull(message = "El perfil no puedo ir vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERFIL")
	private Perfil perfil;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	
	
}
