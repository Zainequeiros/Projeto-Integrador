package com.ceuci.feiraLivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceuci.feiraLivre.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository <ProdutoModel, Long> {

}
