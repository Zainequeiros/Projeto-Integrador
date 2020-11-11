package com.ceuci.feiraLivre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produto")
public class ProdutoModel {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotNull
	public String nome;

	@Column
	public String descricao;

	@Column
	public String produtor;

	@Column
	public double preco;

	@Column
	public String foto;

//	@ManyToOne
//	@JsonIgnoreProperties("produto")
//	private CategoriaModel categoria;

	// get & set
//
//	public CategoriaModel getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(CategoriaModel categoria) {
//		this.categoria = categoria;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getProdutor() {
		return produtor;
	}

	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
