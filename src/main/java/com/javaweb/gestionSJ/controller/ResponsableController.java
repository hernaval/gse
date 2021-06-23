package com.javaweb.gestionSJ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaweb.gestionSJ.dao.ResponsableRepository;
import com.javaweb.gestionSJ.entities.Responsable;
import com.javaweb.gestionSJ.security.Hash;

@Controller
public class ResponsableController {
	@Autowired
	private ResponsableRepository respRepo;
	
	@RequestMapping(value="/gse/responsables")
	public String index(){
		
		return "responsables/responsables";
	}
	
	@RequestMapping(value="/gse/responsables/ajout",method=RequestMethod.POST)
	public String addResponsable(Model model,Responsable responsable){
		Hash hash = new Hash();
		
		responsable.setPassword(hash.getMd5(responsable.getPassword()));
		
		responsable.setRole("ADMIN");
		respRepo.save(responsable);
		return "redirect:/gse/parametres";
	}
	
	
}
