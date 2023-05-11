package com.example.RestApiRJM.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestApiRJM.dao.UsuariosDAO;
import com.example.RestApiRJM.model.Usuario;

@Service
public class UsuarioServicesImpl implements UsuariosService{

	
	@Autowired
	private UsuariosDAO usuariosDAO;
	
	
	@Override
	public Usuario findUsuarioById(Integer idUsuario) {
		return usuariosDAO.findById(idUsuario).orElse(null);
	}

}
