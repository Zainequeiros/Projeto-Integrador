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

import com.ceuci.feiraLivre.model.PedidoModel;
import com.ceuci.feiraLivre.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<PedidoModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoModel> getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(value = "/maiorDe100")
	public ResponseEntity<List<PedidoModel>> findAllMaiorDe100(){
		return ResponseEntity.ok(repository.findAllMaiorDe100());
	}
	
	@PostMapping
	public ResponseEntity<PedidoModel> post(@RequestBody PedidoModel pedido){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pedido));
	}
	
	@PutMapping
	public ResponseEntity<PedidoModel> put(@RequestBody PedidoModel pedido){
		return ResponseEntity.ok(repository.save(pedido));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
