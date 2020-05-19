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

import com.qintess.eventos.api.dados.EventoRepo;
import com.qintess.eventos.api.modelo.Evento;

@RestController
@RequestMapping("/api")
public class EventoController {

	@Autowired
	private EventoRepo erepo;
	
	@GetMapping("/evento")
	public List<Evento> getEventos(){
		return erepo.findAll();
	}
	
	@PostMapping("/evento")
	public void criarEvento(@RequestBody Evento evento){
		erepo.save(evento);
	}
	
	@DeleteMapping("/evento")
	public void deletaEvento(@RequestBody Evento evento){
		erepo.delete(evento);
	}
	
	@PutMapping("/evento")
	public void alteraEvento(@RequestBody Evento evento){
		erepo.save(evento);
	}

}
