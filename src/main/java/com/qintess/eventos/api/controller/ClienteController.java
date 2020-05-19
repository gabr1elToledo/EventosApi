package com.qintess.eventos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.eventos.api.dados.ClienteRepo;
import com.qintess.eventos.api.modelo.Cliente;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteRepo crepo;
	
	
	@GetMapping("/cliente")
	public List<Cliente> getClientes(){
		return crepo.findAll();
	}
	
	@PostMapping("/cliente")
	public void criarCliente(@RequestBody Cliente cliente) {
		crepo.save(cliente);
	}
	
	@DeleteMapping("/cliente")
	public void deleteCliente(@RequestBody Cliente cliente) {
		crepo.delete(cliente);
	}
	
	@PutMapping("/cliente")
	public void alteraCliente(@RequestBody Cliente cliente) {
		crepo.save(cliente);
	}
	
}
