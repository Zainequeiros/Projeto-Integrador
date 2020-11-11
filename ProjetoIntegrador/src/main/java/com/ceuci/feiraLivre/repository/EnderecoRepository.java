package com.ceuci.feiraLivre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ceuci.feiraLivre.model.EnderecoModel;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long>{

	@Query(value = "select * from endereco where cidade like 'S%' ", nativeQuery=true)
	List<EnderecoModel> findAllByCidadeS();
}
