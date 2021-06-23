package com.javaweb.gestionSJ.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javaweb.gestionSJ.dao.RequeteRepository;
import com.javaweb.gestionSJ.entities.Requete;

@Controller
public class RequeteController {
	
    @Autowired
    private RequeteRepository reqRepo;
    
    @RequestMapping(value="/gse/ajoutRequetes")
    public String add(){
    	return "requetes/ajout";
    }

    @RequestMapping(value="/gse/requetes")
    public String index(Model model,
    		@RequestParam(name="page",defaultValue="1") int p,
    		@RequestParam(name="size",defaultValue="3") int s
    		){

        Page <Requete> list = reqRepo.findAll(PageRequest.of(p-1, s,Sort.by("dateTraitement").descending()));
        int[] pages = new int[list.getTotalPages()];
        model.addAttribute("listReq",list);
        model.addAttribute("pages", pages);
		model.addAttribute("size",s);
        return "requetes/requetes";
    }

    @RequestMapping(value="/gse/requetes/ajout",method = RequestMethod.POST)
    public String ajout(Model model,Requete req,RedirectAttributes redir ){
        reqRepo.save(req);
        redir.addFlashAttribute("addSuccess","Requête ajoutée avec succès");

        return "redirect:/gse/ajoutRequetes";
    }

    @RequestMapping(value="/gse/requetes/modification",method=RequestMethod.POST)
	
	public String edit(Model model,
			
			Requete req,
			RedirectAttributes redir){
		
		
		reqRepo.save(req);
		 
		//ResponseEntity<void> response = new ResponseEntity<>(1,HttpStatus.OK);
		redir.addFlashAttribute("editSuccess");
		return "redirect:/gse/requetes";
	}
	

    
}
