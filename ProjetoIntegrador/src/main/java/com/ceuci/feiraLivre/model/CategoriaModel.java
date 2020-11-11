package com.ceuci.feiraLivre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="categoria")
public class CategoriaModel {
	
	//ATRIBUTOS
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotNull
	public String categoria;
	
	@Column
	public boolean organico;
	
	@Column
	public String unidade_medida;
	
//	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
//	@JsonIgnoreProperties("categoria")
//	private List<ProdutoModel> produto;
	
	
	//get e set

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return categoria;
	}

	public void setTipo(String tipo) {
		this.categoria = tipo;
	}

	public boolean isOrganico() {
		return organico;
	}

	public void setOrganico(boolean organico) {
		this.organico = organico;
	}

	public String getUnidade_medida() {
		return unidade_medida;
	}

	public void setUnidade_medida(String unidade_medida) {
		this.unidade_medida = unidade_medida;
	}
	
	
	
	
	

}
