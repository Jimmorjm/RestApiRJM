package com.example.RestApiRJM.test;

import java.util.List;

import com.example.RestApiRJM.model.Usuario;


public class HilosVo extends Thread{
	
	
	
	private List<Usuario> lstUsuarios;
	private String nombre;
	private Long initialTime;
	
     public HilosVo(List<Usuario> lstUsuarios, String nombre, Long initialTime) {
		this.lstUsuarios = lstUsuarios;
		this.nombre = nombre;
		this.initialTime = initialTime;
	}

	@Override
     public void run(){
    	 System.out.println(nombre +" iniciado");
    	 lstUsuarios.forEach((u) -> {
    		 System.out.println("Usuario :"+u.getNombre()+" procesado");
    	 });
    	 System.out.println(nombre +" Finalizado");
     }

	public List<Usuario> getLstUsuarios() {
		return lstUsuarios;
	}
	public void setLstUsuarios(List<Usuario> lstUsuarios) {
		this.lstUsuarios = lstUsuarios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getInitialTime() {
		return initialTime;
	}
	public void setInitialTime(Long initialTime) {
		this.initialTime = initialTime;
	}
     
     
}
