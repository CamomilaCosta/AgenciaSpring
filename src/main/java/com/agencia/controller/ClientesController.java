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

import com.agencia.model.Clientes;
import com.agencia.repository.ClientesRepository;

@Controller
@RequestMapping("/admin")
public class ClientesController {
	@Autowired
	private ClientesRepository clientesrepository;
	
	@GetMapping("/clientes")
	public ModelAndView Clientes(){
		
		ModelAndView modelAndViewClientes = new ModelAndView("admin/clientes/listarcliente.html");
		List<Clientes> clientes = clientesrepository.findAll();
		modelAndViewClientes.addObject("clientes", clientes);
		return modelAndViewClientes;
		
	}
	
	@GetMapping("/cadastrarclientes")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("admin/clientes/adicionarcliente.html");

		modelAndView.addObject("cliente", new Clientes());

		return modelAndView;
	}

    @PostMapping("/cadastrarclientes")
	public ModelAndView cadastrar(Clientes cliente) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/admin/clientes");

		clientesrepository.save(cliente);

		return modelAndView;
	}
    
    @GetMapping("/{id}/editarcliente")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("admin/clientes/editarcliente.html");

		Clientes cliente = clientesrepository.getReferenceById(id);
		modelAndView.addObject("cliente", cliente);

		return modelAndView;
	}

	@PostMapping("/{id}/editarcliente")
	public ModelAndView editar(Clientes cliente) {	


		clientesrepository.save(cliente);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/clientes");

		return modelAndView;
	}
	
	@GetMapping("/{id}/excluircliente")
	public String excluir(@PathVariable Long id) {
		clientesrepository.deleteById(id);

		return "redirect:/admin/clientes";
	}
	

}
