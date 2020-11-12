package com.ceuci.feiraLivre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceuci.feiraLivre.model.ProdutorModel;

public interface ProdutorRepository extends JpaRepository<ProdutorModel, Long>{
	public List<ProdutorModel> findAllByNomeContainingIgnoreCase (String nome);
}
