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

import com.agencia.model.Hoteis;
import com.agencia.repository.HoteisRepository;

@Controller
@RequestMapping("/admin")
public class HoteisController {
	@Autowired
	private HoteisRepository hoteisrepository;
	
	@GetMapping("/hoteis")
	public ModelAndView Hoteis(){
		
		ModelAndView modelAndViewHotels = new ModelAndView("admin/hoteis/listarhoteis.html");
		List<Hoteis> hoteis = hoteisrepository.findAll();
		modelAndViewHotels.addObject("hoteis", hoteis);
		return modelAndViewHotels;
		
	}
	
	@GetMapping("/cadastrarhoteis")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("admin/hoteis/adicionarhoteis.html");

		modelAndView.addObject("hotel", new Hoteis());

		return modelAndView;
	}

    @PostMapping("/cadastrarhoteis")
	public ModelAndView cadastrar(Hoteis hotel) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/admin/hoteis");

		hoteisrepository.save(hotel);

		return modelAndView;
	}
    
    @GetMapping("/{id}/editarhotel")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("admin/hoteis/editarhotel.html");

		Hoteis hotel = hoteisrepository.getReferenceById(id);
		modelAndView.addObject("hotel", hotel);

		return modelAndView;
	}

	@PostMapping("/{id}/editarhotel")
	public ModelAndView editar(Hoteis hotel) {	


		hoteisrepository.save(hotel);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/hoteis");

		return modelAndView;
	}
	
	@GetMapping("/{id}/excluirhotel")
	public String excluir(@PathVariable Long id) {
		hoteisrepository.deleteById(id);

		return "redirect:/admin/hoteis";
	}
	

}
