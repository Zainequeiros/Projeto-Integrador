package com.ceuci.feiraLivre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceuci.feiraLivre.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{

	public List<ProdutoModel> findAllByNomeContainingIgnoreCase (String nome);

}
