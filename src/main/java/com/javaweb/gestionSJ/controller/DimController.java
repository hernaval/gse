package com.javaweb.gestionSJ.controller;

import java.time.LocalDate;

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

import com.javaweb.gestionSJ.dao.DimRepository;
import com.javaweb.gestionSJ.entities.Dim;

@Controller
public class DimController {
	
	@Autowired
	private DimRepository dimRepo;
	
	@RequestMapping(value="/gse/dims")
	public String index(Model model,
			@RequestParam(name="page",defaultValue="1")int p,
			@RequestParam(name="size",defaultValue="3")int s){
		Page<Dim> list = dimRepo.findAll(PageRequest.of(p-1,s));
		int[] pages = new int[list.getTotalPages()]; 
		model.addAttribute("listDim", list);
		model.addAttribute("pages", pages);
		model.addAttribute("size",s);
		return "dims/dims";
	}
	
	@RequestMapping(value="/gse/ajoutDims")
	public String formDim(){
		
		return "dims/ajout";
	}
	
	@RequestMapping(value="/gse/dims/ajout")
	public String addDim(Model model,Dim dim,RedirectAttributes redir){
		String date = LocalDate.now().toString();
		dim.setDate_dim(date);
		dimRepo.save(dim);
		redir.addFlashAttribute("addSuccess", "ajout DIM réussi");
		return "redirect:/gse/ajoutDims";
	}

	@RequestMapping(value="/gse/dims/modification",method=RequestMethod.POST)
	public String edit(Model model ,Dim dim,RedirectAttributes redir){
		
		dimRepo.save(dim);
		
		return "redirect:/gse/dims";
	}
	
	//@RequestMapping(value="/gse/dims/search",method=RequestMethod.POST)
	/*public Model search(Model model,HttpServletRequest resp){
		String code = resp.getParameter("code_dim");
		
		//Model m = model.addAttribute("listDim",  dimRepo.chercher("%" +code+"%"));
		return m;
	}*/
}
