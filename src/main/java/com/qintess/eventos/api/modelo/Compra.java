package com.qintess.eventos.api.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<CompraEvento> getEventos() {
		return eventos;
	}

	public void setEventos(List<CompraEvento> eventos) {
		this.eventos = eventos;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false, scale = 2)
	private BigDecimal valor = new BigDecimal(0);
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval= true)
	private List<CompraEvento> eventos = new ArrayList<CompraEvento>();
	
	public void adicionaEvento(Evento evento, int quantidade) {
		CompraEvento compraEvento = new CompraEvento(this,evento, quantidade);
		eventos.add(compraEvento);
		evento.getCompras().add(compraEvento);
		double valorCompra = this.valor.doubleValue();
		double valorEventoUnit = evento.getValorUnitario().doubleValue();
		valorCompra += (valorEventoUnit * quantidade);
		
		this.valor = new BigDecimal(valorCompra);
	}

	public int getId() {
		return 0;
	}

}
