package com.yassine.voiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.yassine.voiture.entities.Location;
import com.yassine.voiture.entities.Voiture;
import com.yassine.voiture.repos.VoitureRepository;


@Service
public class VoitureServiceImpl implements VoitureService {
	
	@Autowired
	private VoitureRepository voitureRepository ;
	
	public Voiture saveVoiture(Voiture v) {
		return voitureRepository.save(v);
	}
	
	@Override
	public Voiture updateVoiture(Voiture v) {
		return voitureRepository.save(v);
	}
	
	@Override
	public void deleteVoiture(Voiture v) {
		voitureRepository.delete(v);
	}
	
	@Override
	public void deleteVoitureById(Long id) {
		voitureRepository.deleteById(id);
	}
	
	@Override
	public Voiture getVoiture(Long id) {
		return voitureRepository.findById(id).get();
	}
	
	@Override
	public List<Voiture> getAllVoiture() {
		return voitureRepository.findAll();
	}
	@Override
	public Page<Voiture> getAllVoitureParPage(int page, int size) {
	return voitureRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Voiture> findBymarque(String marque) {
	return ((VoitureServiceImpl) voitureRepository).findBymarque(marque);
	}
	
	@Override 
	public List<Voiture> findBymarqueContains(String marque) {
		return ((VoitureServiceImpl) voitureRepository).findBymarqueContains(marque);
		}
	
	@Override
	public List<Voiture> findBymarque(String marque, String modele) {
		return voitureRepository.findBymarque(marque, modele);
	}
	@Override
	public List<Voiture> findByLocation(Location location) {
	return voitureRepository.findByLocation(location);
	}
	@Override
	public List<Voiture> findByLocationidlocation(Long id) {
	return voitureRepository.findByLocationidlocation(id);
	} 
	@Override
	public List<Voiture> findByOrderBymarqueVoitureAsc() {
	return voitureRepository.findByOrderBymarqueVoitureAsc();
	}
	@Override
	public List<Voiture> trierVoituremarquemodele() {
	return voitureRepository.trierVoituremarquemodele();
	}
	
	

	

}