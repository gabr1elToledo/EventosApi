package com.qintess.eventos.api.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.qintess.eventos.api.modelo.CasaDeShow;
import com.qintess.eventos.api.modelo.CompraEvento;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private int qtdIngressos;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private BigDecimal valorUnitario;
	
	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] imagemProd;
	
	@Transient 
	private String imagemEncoded;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtEvento;
	
	@Column(nullable = false, length = 2000)
	private String descricao;
	
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CompraEvento> compras = new ArrayList<CompraEvento>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("casaDeShowId")
	private CasaDeShow casaDeShow;
	

	public List<CompraEvento> getCompras() {
		return compras;
	}

	public void setCompras(List<CompraEvento> compras) {
		this.compras = compras;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public byte[] getImagemProd() {
		return imagemProd;
	}

	public void setImagemProd(byte[] imagemProd) {
		this.imagemProd = imagemProd;
	}
	
	public String getImagemEncoded() {
		return imagemEncoded;
	}

	public void setImagemEncoded(String imagemEncoded) {
		this.imagemEncoded = imagemEncoded;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdIngressos() {
		return qtdIngressos;
	}

	public void setQtdIngressos(int qtdIngressos) {
		this.qtdIngressos = qtdIngressos;
	}

	public LocalDate getDtEvento() {
		return dtEvento;
	}

	public void setDtEvento(LocalDate dtEvento) {
		this.dtEvento = dtEvento;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", qtdIngressos=" + qtdIngressos + ", nome=" + nome + ", valorUnitario="
				+ valorUnitario + ", imagemProd=" + Arrays.toString(imagemProd) + ", imagemEncoded=" + imagemEncoded
				+ ", dtEvento=" + dtEvento + ", descricao=" + descricao + "]";
	}

}
