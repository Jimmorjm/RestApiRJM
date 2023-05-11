package com.example.RestApiRJM.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.RestApiRJM.dao.UsuariosDAO;
import com.example.RestApiRJM.model.RequestRest;
import com.example.RestApiRJM.model.Usuario;
import com.example.RestApiRJM.services.UsuariosService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping( path = "/usuarios")
@CrossOrigin("*")
public class UsuariosControllerRest {
	
	@Autowired
	private UsuariosDAO usuarioDAO;
	@Autowired
	private UsuariosService usuariosService;
	
	
	private Logger logger = LoggerFactory.getLogger(UsuariosControllerRest.class);
	
	
	@DeleteMapping(path = "/deleteUsaurioById/{idUsuario}")
	public void deleteUsuarioById(@PathVariable Integer idUsuario) {
		logger.info("Usuario eliminado: "+idUsuario);
		usuarioDAO.deleteById(idUsuario);
	}
	
	@PostMapping(path = "/saveUsuario")
	public ResponseEntity<Usuario> saveUsuario(@Valid @RequestBody Usuario usuario, BindingResult result) {
		try {
			if(result.hasErrors()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, getMessageError(result));
			}
			usuarioDAO.save(usuario);
			logger.info("Usuario creado: "+usuario.getIdUsuario());
			return ResponseEntity.status(HttpStatus.OK).body(usuario);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping (path = "/findUsuarioById")
	public Usuario findUsuarioById(@RequestParam(value = "idUsuario", defaultValue = "1", required = false) Integer idUsuario) {
		Usuario usu=null;
		usu = usuariosService.findUsuarioById(idUsuario);
		return usu;
	}
	
	@GetMapping(path = "/findAllUssers")
	public List<Usuario> findAllUssers(){
		return usuarioDAO.findAll();
	}
	
	@PutMapping(path = "/updateUsuarioById")
	public void updateUsuarioById(@RequestBody Usuario usuario) {
		logger.info("Usario Actcualizado: "+usuario.getIdUsuario());
		usuarioDAO.save(usuario);
	}
	
	
	
	public String getMessageError(BindingResult result) {
		List<Map<String, String>> errors= result.getFieldErrors().stream()
				.map(err ->{
					Map<String, String> mapErrors= new HashMap<>();
					mapErrors.put(err.getField(), err.getDefaultMessage());
					return mapErrors;
				}).collect(Collectors.toList());
		
		RequestRest res= new RequestRest("01", errors);
		
		ObjectMapper mapper= new ObjectMapper();
		String jsonToString="";
		try {
			jsonToString= mapper.writeValueAsString(res);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonToString;
	}
	
}
