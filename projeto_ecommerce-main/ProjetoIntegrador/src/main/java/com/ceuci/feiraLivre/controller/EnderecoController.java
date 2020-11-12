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

import com.ceuci.feiraLivre.model.EnderecoModel;
import com.ceuci.feiraLivre.model.ProdutoModel;
import com.ceuci.feiraLivre.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
@CrossOrigin("*")
public class EnderecoController {

	@Autowired
	private EnderecoRepository repository;

	//Pegar todos os endereços
	@GetMapping
	public ResponseEntity<List<EnderecoModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());

	}
	//Pegar por ID
	@GetMapping("/{id}")
	public ResponseEntity<EnderecoModel> GetById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());

	}

//	@GetMapping(value = "/cidadeS")
//	public ResponseEntity<List<EnderecoModel>> findAllByCidadeS(){
//		return ResponseEntity.ok(repository.findAllByCidadeS());
//	}
	//Pegar por cidade
	@GetMapping("/cidades/{cidade}")
	public ResponseEntity<List<EnderecoModel>> getByCidade(@PathVariable String cidade){
		return ResponseEntity.ok(repository.findAllByCidadeContainingIgnoreCase(cidade));
	}
	//Inserir
	@PostMapping
	public ResponseEntity<EnderecoModel> post(@RequestBody EnderecoModel endereco) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(endereco));
	}
	//Atualizar
	@PutMapping
	public ResponseEntity<EnderecoModel> put(@RequestBody EnderecoModel endereco) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(endereco));
	}
	//Deletar
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
