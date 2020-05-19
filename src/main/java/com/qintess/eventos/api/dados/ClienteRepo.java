package com.qintess.eventos.api.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.eventos.api.modelo.Cliente;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

}
