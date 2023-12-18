package com.agencia.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agencia.model.Voos;
import com.agencia.repository.VoosRepository;

@Controller
@RequestMapping("/admin")
public class VoosController {
	@Autowired
	private VoosRepository voosrepository;
	
	@GetMapping("/voos")
	public ModelAndView Voos(){
		
		ModelAndView modelAndViewVoos = new ModelAndView("admin/voos/listarvoos.html");
		List<Voos> voos = voosrepository.findAll();
		modelAndViewVoos.addObject("voos", voos);
		return modelAndViewVoos;
		
	}
	
	@GetMapping("/cadastrarvoos")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("admin/voos/adicionarvoos.html");

		modelAndView.addObject("voo", new Voos());

		return modelAndView;
	}

    @PostMapping("/cadastrarvoos")
	public ModelAndView cadastrar(Voos voo) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/admin/voos");

		voosrepository.save(voo);

		return modelAndView;
	}
    
    @GetMapping("/{id}/editarvoo")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("admin/voos/editarvoos.html");

		Voos voo = voosrepository.getReferenceById(id);
		modelAndView.addObject("voo", voo);

		return modelAndView;
	}

	@PostMapping("/{id}/editarvoo")
	public ModelAndView editar(Voos voo) {	


		voosrepository.save(voo);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/voos");

		return modelAndView;
	}
	
	@GetMapping("/{id}/excluirvoo")
	public String excluir(@PathVariable Long id) {
		voosrepository.deleteById(id);

		return "redirect:/admin/voos";
	}
	

}
