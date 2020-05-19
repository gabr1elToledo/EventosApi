package com.qintess.eventos.api.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.eventos.api.modelo.Compra;

public interface CompraRepo extends JpaRepository<Compra,Integer>{

}
