package com.agencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agencia.repository.ClientesRepository;

@Controller
@RequestMapping("/admin")
public class ClientesController {
	@Autowired
	private ClientesRepository clientesrepository;
	
	@GetMapping("/clientes")
	public ModelAndView Clientes(){
		
		ModelAndView modelAndViewClientes = new ModelAndView("admin/clientes/listarcliente.html");
		
		modelAndViewClientes.addObject("clientes", clientesrepository.findAll());
		return modelAndViewClientes;
		
	}
	

	
	

}
