package com.yassine.voiture.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yassine.voiture.entities.Location;
import com.yassine.voiture.entities.Voiture;

public interface VoitureService {
	
	static Voiture saveVoiture(Voiture v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	Voiture updateVoiture(Voiture v);
	
	void deleteVoiture(Voiture v);
	
	void deleteVoitureById(Long id);
	
	Voiture getVoiture(Long id);

	
	List<Voiture> getAllVoiture();
	Page<Voiture> getAllVoitureParPage(int page, int size);

	List<Voiture> findBymarque(String marque);
	List<Voiture> findBymarqueContains(String marque);
	List<Voiture> findBymarque (String marque, String modele);
	List<Voiture> findByLocation (Location location);
	List<Voiture> findByLocationidlocation(Long id);
	List<Voiture> findByOrderBymarqueVoitureAsc();
	List<Voiture> trierVoituremarquemodele();

	


}
