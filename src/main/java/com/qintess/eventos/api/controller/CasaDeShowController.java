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

import com.qintess.eventos.api.dados.CasaDeShowRepo;
import com.qintess.eventos.api.modelo.CasaDeShow;

@RestController
@RequestMapping("/api")
public class CasaDeShowController {

	@Autowired
	private CasaDeShowRepo csrepo;
	
	
	@GetMapping("/casaShow")
	public List<CasaDeShow> getCasaDeShows(){
		return csrepo.findAll();
	}
	
	@PostMapping("/casaShow")
	public void criarCasaDeShow(@RequestBody CasaDeShow casaDeShow) {
		csrepo.save(casaDeShow);
	}
	
	@DeleteMapping("/casaShow")
	public void deleteCasaDeShow(@RequestBody CasaDeShow casaDeShow) {
		csrepo.delete(casaDeShow);
	}
	
	@PutMapping("/casaShow")
	public void alteraCasaDeShow(@RequestBody CasaDeShow casaDeShow) {
		csrepo.save(casaDeShow);
	}
	
}
