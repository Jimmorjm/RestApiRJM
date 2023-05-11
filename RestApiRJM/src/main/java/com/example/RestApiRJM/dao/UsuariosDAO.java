package com.example.RestApiRJM.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RestApiRJM.model.Usuario;

@Repository
public interface UsuariosDAO extends JpaRepository<Usuario, Integer> {

	
}
