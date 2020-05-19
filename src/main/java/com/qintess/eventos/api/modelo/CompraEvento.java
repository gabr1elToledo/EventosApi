package com.qintess.eventos.api.modelo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Compra_Evento")
public class CompraEvento {

	@EmbeddedId
	private CompraEventoId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("compraId")
	private Compra compra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("eventoId")
	private Evento evento;
	
	@Column(nullable = false)
	private int quantidade;
	
	private CompraEvento() {}
	
	public CompraEvento(Compra compra, Evento evento, int quantidade) {
		this.compra = compra;
		this.evento = evento;
		this.quantidade = quantidade;
		this.id = new CompraEventoId(compra.getId(), evento.getId());
	}

	public CompraEventoId getId() {
		return id;
	}

	public void setId(CompraEventoId id) {
		this.id = id;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
