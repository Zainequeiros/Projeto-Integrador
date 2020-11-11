package com.ceuci.feiraLivre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceuci.feiraLivre.model.UsuarioModel;
import com.ceuci.feiraLivre.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
				
	}
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<UsuarioModel>> getByTitulo(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<UsuarioModel> post (@RequestBody UsuarioModel postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<UsuarioModel> put (@RequestBody UsuarioModel postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
