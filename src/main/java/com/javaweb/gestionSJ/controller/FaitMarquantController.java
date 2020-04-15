package com.javaweb.gestionSJ.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javaweb.gestionSJ.dao.ActiviteRepository;
import com.javaweb.gestionSJ.dao.FaitMarquantRepository;
import com.javaweb.gestionSJ.entities.Activite;
import com.javaweb.gestionSJ.entities.FaitMarquant;

@Controller
public class FaitMarquantController {
	@Autowired
	private FaitMarquantRepository fmqRepo;
	@Autowired
	private ActiviteRepository activity;
	
	@RequestMapping(value="/gse/faitmarquants")
	public String index(Model model,
			@RequestParam(name="page",defaultValue="1")int p,
			@RequestParam(name="size",defaultValue="3")int s){
		
		Page<FaitMarquant> fmq = fmqRepo.findAll(PageRequest.of(p-1, s));
		
		int[] pages = new int[fmq.getTotalPages()];
		model.addAttribute("faitmarquants", fmq);
		model.addAttribute("pages", pages);
		model.addAttribute("size",s);
		return "faitmarquants/faitmarquants";
	}
	
	
	@RequestMapping(value="/gse/faitmarquants/ajout",method=RequestMethod.POST)
	@Transactional
	public String finish(Model model, FaitMarquant fmq, Activite act,RedirectAttributes redir){
		String today =LocalDate.now().toString();
		fmq.setDate_liv_fmq(today);
		fmqRepo.save(fmq);
		act.setEtat_act("ok");
		activity.save(act);
		redir.addAttribute("addSuccess", "Fait marquant MAJ ");
		return "redirect:/gse/faitmarquants";
	}
	
	@RequestMapping(value="/gse/faitmarquants/modification",
			method=RequestMethod.POST)
	public String editFmq(FaitMarquant fmq){
		fmqRepo.save(fmq);
		return "redirect:/gse/faitmarquants";
	}

}
