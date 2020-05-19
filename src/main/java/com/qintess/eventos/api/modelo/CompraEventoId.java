package com.qintess.eventos.api.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CompraEventoId implements Serializable {

	private int compraId;
	
	private int eventoId;
	
	public CompraEventoId(int compraId, int eventoId) {
		this.compraId = compraId;
		this.eventoId = eventoId;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		
		if(o == null || getClass() != o.getClass())
			return false;
		
		CompraEventoId that = (CompraEventoId) o;
		return Objects.equals(compraId, that.compraId) &&
			   Objects.equals(eventoId, that.eventoId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(compraId, eventoId);
	}

	public int getCompraId() {
		return compraId;
	}

	public void setCompraId(int compraId) {
		this.compraId = compraId;
	}

	public int getEventoId() {
		return eventoId;
	}

	public void setEventoId(int eventoId) {
		this.eventoId = eventoId;
	}
	
	
}
