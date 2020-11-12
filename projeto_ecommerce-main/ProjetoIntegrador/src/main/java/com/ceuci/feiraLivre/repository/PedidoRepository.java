package com.ceuci.feiraLivre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ceuci.feiraLivre.model.PedidoModel;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long>{
	
	@Query(value = "select * from pedido where valor > 100", nativeQuery=true)
	List<PedidoModel> findAllMaiorDe100();
}
