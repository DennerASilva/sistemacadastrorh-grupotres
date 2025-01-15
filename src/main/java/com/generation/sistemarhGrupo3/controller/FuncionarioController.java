package com.generation.sistemarhGrupo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.sistemarhGrupo3.model.Funcionario;
import com.generation.sistemarhGrupo3.repository.FuncionarioRepository;

@RestController
@RequestMapping("/Funcionários")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> getAll(){
		return ResponseEntity.ok(funcionarioRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getById(@PathVariable Long id){
		return funcionarioRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<List<Funcionario>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(funcionarioRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
}
