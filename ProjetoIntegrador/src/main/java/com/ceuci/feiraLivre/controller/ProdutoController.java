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

import com.ceuci.feiraLivre.model.ProdutoModel;
import com.ceuci.feiraLivre.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> GetById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
				
	}
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<ProdutoModel>> getByTitulo(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> post (@RequestBody ProdutoModel postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> put (@RequestBody ProdutoModel postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}