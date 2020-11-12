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

import com.ceuci.feiraLivre.model.ProdutorModel;
import com.ceuci.feiraLivre.repository.ProdutorRepository;


@RestController
@RequestMapping("/produtor")
@CrossOrigin("*")
public class ProdutorController {

	@Autowired
	private ProdutorRepository repository;
	
	//Pegar todos os produtos
	@GetMapping
	public ResponseEntity<List<ProdutorModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	//Pegar por ID
	@GetMapping("/{id}")
	public ResponseEntity<ProdutorModel> GetById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());	
	}
	//Pegar por nome
	@GetMapping("/titulo/{nome}")
	public ResponseEntity<List<ProdutorModel>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	//Inserir
	@PostMapping
	public ResponseEntity<ProdutorModel> post (@RequestBody ProdutorModel postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	//Atualizar
	@PutMapping
	public ResponseEntity<ProdutorModel> put (@RequestBody ProdutorModel postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	//Deletar
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
