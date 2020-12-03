package com.yassine.voiture;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import com.yassine.voiture.entities.Voiture;
import com.yassine.voiture.service.VoitureService;



@Component
@SpringBootApplication

public class VoitureApplication implements CommandLineRunner {
	@Autowired
		VoitureService voitureService ;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(VoitureApplication.class, args);
	}
	
	@Override
	public void run(String... args) 
			throws Exception {
		VoitureService.saveVoiture(new Voiture("bmw","i8","300 TN 1258","Rouge","12 CV",20.0 ,new Date()));
		VoitureService.saveVoiture(new Voiture("peugeot","404","50 TN 1258","gris","4 CV",1.0 ,new Date()));
		VoitureService.saveVoiture(new Voiture("peugeot","partner","120 TN 1258","Rouge","6 CV",5.0 ,new Date()));
			
		repositoryRestConfiguration.exposeIdsFor(Voiture.class);

	}
	
	
	
}
