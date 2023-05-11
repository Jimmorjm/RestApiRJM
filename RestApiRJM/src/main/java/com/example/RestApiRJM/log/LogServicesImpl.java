package com.example.RestApiRJM.log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.stereotype.Service;


@Service
public class LogServicesImpl implements LogServices{
	
	
	public static void main(String[] args) throws IOException {
		
		
		File file = new File("C:/WSP/RestApiRJM/src/main/resources/log4j2.xml");
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		final ConfigurationSource source = new ConfigurationSource(in);
		Configurator.initialize(null, source);
		
		Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

		logger.debug("El número de grupos de excepciones estadísticas es anormal y la información de la excepción es la siguiente: e.getStackTrace (). ToString ()");
		logger.error("El número de grupos de excepciones estadísticas es anormal y la información de la excepción es la siguiente: e.getStackTrace (). ToString ()");
		logger.info("El número de grupos de excepciones estadísticas es anormal y la información de la excepción es la siguiente: e.getStackTrace (). ToString ()");
	}

}
