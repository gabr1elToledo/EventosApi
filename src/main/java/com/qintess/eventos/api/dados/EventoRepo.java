package com.qintess.eventos.api.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.eventos.api.modelo.Evento;

public interface EventoRepo extends JpaRepository<Evento,Integer> {

}
