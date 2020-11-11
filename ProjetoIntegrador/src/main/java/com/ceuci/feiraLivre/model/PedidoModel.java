package com.ceuci.feiraLivre.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class PedidoModel {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private double valor;
	
	@Column
	private Date data;
	
//	@Column
//	@JsonIgnoreProperties("pedido")
//	private List<ProdutoModel> produto;
	
	@Column
	private int quantidadeItens;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

//	public List<ProdutoModel> getProduto() {
//		return produto;
//	}
//
//	public void setProduto(List<ProdutoModel> produto) {
//		this.produto = produto;
//	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(int quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}
	
}
