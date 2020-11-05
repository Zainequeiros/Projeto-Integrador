package com.ceuci.feiraLivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceuci.feiraLivre.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

}
