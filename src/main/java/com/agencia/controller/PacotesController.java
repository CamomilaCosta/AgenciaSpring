package com.agencia.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agencia.model.Hoteis;
import com.agencia.model.Pacotes;
import com.agencia.model.Voos;
import com.agencia.repository.HoteisRepository;
import com.agencia.repository.PacotesRepository;
import com.agencia.repository.VoosRepository;

@Controller
@RequestMapping("/admin")
public class PacotesController {
	@Autowired
	private VoosRepository voosrepository;
	@Autowired
	private HoteisRepository hoteisrepository;
	@Autowired
	private PacotesRepository pacotesrepository;
	
	@Transactional
	@GetMapping("/pacotes")
	public ModelAndView Pacotes(){
		
		ModelAndView modelAndViewPacotes = new ModelAndView("admin/pacotes/listarpacotes.html");
		List<Voos> voos = voosrepository.findAll();
		List<Hoteis> hoteis = hoteisrepository.findAll();
		List<Pacotes> pacotes = pacotesrepository.findAll();
		modelAndViewPacotes.addObject("voos", voos);
		modelAndViewPacotes.addObject("hoteis", hoteis);
		modelAndViewPacotes.addObject("pacotes", pacotes);
		return modelAndViewPacotes;
		
	}
	
	@GetMapping("/cadastrarpacotes")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("admin/pacotes/adicionarpacotes.html");

		modelAndView.addObject("pacotes", new Pacotes());
		modelAndView.addObject("hoteis", hoteisrepository.findAll());
		modelAndView.addObject("voos", voosrepository.findAll());

		return modelAndView;
	}

    @PostMapping("/cadastrarpacotes")
	public ModelAndView cadastrar1(Pacotes pacote) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/admin/pacotes");

		pacotesrepository.save(pacote);

		return modelAndView;
	}
    
    @GetMapping("/{id}/editarpacote")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("admin/pacotes/editarpacotes.html");

		Pacotes pacote = pacotesrepository.getReferenceById(id);
		List<Voos> voos = voosrepository.findAll();
		List<Hoteis> hoteis = hoteisrepository.findAll();
		modelAndView.addObject("voos", voos);
		modelAndView.addObject("hoteis", hoteis);
		modelAndView.addObject("pacote", pacote);

		return modelAndView;
	}

	@PostMapping("/{id}/editarpacote")
	public ModelAndView editar(Pacotes pacote) {	


		pacotesrepository.save(pacote);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/pacotes");

		return modelAndView;
	}
	
	@GetMapping("/{id}/excluirpacote")
	public String excluir(@PathVariable Long id) {
		pacotesrepository.deleteById(id);

		return "redirect:/admin/pacotes";
	}
	

}
