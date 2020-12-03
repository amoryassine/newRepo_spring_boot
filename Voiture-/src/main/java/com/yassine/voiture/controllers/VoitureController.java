package com.yassine.voiture.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import com.yassine.voiture.entities.Voiture;
import com.yassine.voiture.service.VoitureService;


@Controller
public class VoitureController {
	@Autowired
	VoitureService voitureService;
	
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap){
		modelMap.addAttribute("voiture", new Voiture());
		modelMap.addAttribute("mode", "new");
		return "fromVoiture";
	}


	@RequestMapping("/saveVoiture")
	public String saveVoiture(@Valid Voiture voiture,BindingResult bindingResult) {
														
		if (bindingResult.hasErrors()) return "fromVoiture";				
		VoitureService.saveVoiture(voiture);
		return "fromVoiture";
		}
	

	  
	  @RequestMapping("/listeVoiture")
	  public String ListeVoiture(ModelMap modelMap,
			  								@RequestParam (name="page",defaultValue = "0") int page,
			  								@RequestParam (name="size", defaultValue = "2") int size)
	  {
		  
	  Page<Voiture> v = voitureService.getAllVoitureParPage(page, size);
	  modelMap.addAttribute("voiture", v);
	  modelMap.addAttribute("pages", new int[v.getTotalPages()]);
	  modelMap.addAttribute("currentPage", page);
	  return "listeVoiture";
	  }
	  
	  
	   

	   
	   @RequestMapping("/supprimerVoiture") 
	   public String supprimerVoiture(@RequestParam("id") Long id,
			   							ModelMap modelMap,
			   							@RequestParam (name="page",defaultValue = "0") int page,
			   							@RequestParam (name="size", defaultValue = "2") int size)
			   {
		   voitureService.deleteVoitureById(id);
			   Page<Voiture> v = voitureService.getAllVoitureParPage(page, size);
			   modelMap.addAttribute("voiture", v);
			   modelMap.addAttribute("pages", new int[v.getTotalPages()]);
			   modelMap.addAttribute("currentPage", page);
			   modelMap.addAttribute("size", size);
			   return "listeVoiture";
			   }
	   
	   
	   
	   
	   
	   
	    @RequestMapping({"/modifierVoiture"})
	    public String editerVoiture(@RequestParam("id") Long id, ModelMap modelMap) {
	        Voiture v = voitureService.getVoiture(id);
	        modelMap.addAttribute("voiture",v);
	        modelMap.addAttribute("mode", "new");
	        return "fromVoiture";
	    }
	    
	    @RequestMapping({"/updateVoiture"})
	    public String updateVoiture(@ModelAttribute("voiture") Voiture voiture,
	    							@RequestParam("date") String date,
	    							ModelMap modelMap) throws ParseException {
	    	
	        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	        Date date_creation_voiture = dateformat.parse(String.valueOf(date));
	        voiture.setDate_creation_voiture(date_creation_voiture);
	        
	        voitureService.updateVoiture(voiture);
	        List<Voiture> v = voitureService.getAllVoiture();
	        modelMap.addAttribute("Voiture", v);
	        return "listeVoiture";
	    }
	    


	    
	
}
