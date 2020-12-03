package com.yassine.voiture.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yassine.voiture.entities.Location;
import com.yassine.voiture.entities.Voiture;

@RepositoryRestResource(path = "rest")
public interface VoitureRepository extends JpaRepository<Voiture, Long> {
	
	
	List<Voiture> findBymarqueVoiture(String marque);
	List<Voiture> findBymarqueVoitureContains(String marque);
	
	/*@Query
	("select v from Voiture v where v.marque like %?1 and v.modele > ?2") 
	List<Voiture> findBymarque (String marque, String modele); */
	
	@Query("select v from Voiture v where v.marque like %:marque and v.modele > :modele")
	List<Voiture> findBymarque (@Param("marque") String marque,@Param("modele") String modele);
	
	@Query
	("select v from Voiture v where v.location = ?1") 
	List<Voiture> findByLocation (Location location);
	
	List<Voiture> findByLocationidlocation(Long id);
	
	List<Voiture> findByOrderBymarqueVoitureAsc();
	
	@Query
	("select v from Voiture v order by v.marque ASC, v.modele DESC")
	List<Voiture> trierVoituremarquemodele ();

}
