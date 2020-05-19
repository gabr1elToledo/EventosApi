package com.qintess.eventos.api.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.eventos.api.modelo.Papel;

public interface PapelRepo extends JpaRepository<Papel,Integer> {

}
