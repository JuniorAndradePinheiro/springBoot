package com.algaworks.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.crm.model.Cliente;
import com.algaworks.crm.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired // Já setta a variavel com um objeto da interface 
	private ClienteRepository clienteRespository;
	
	@GetMapping // mapeia toda requisição GET de url "/clientes" para esse método
	public List<Cliente> listar() {
		return clienteRespository.findAll();
	}
	
	@PostMapping // mapeia toda requisição POST de url "/clientes" para esse método
	@ResponseStatus(HttpStatus.CREATED)// Muda o código de 200(código padrão) para 201(de criação) que é o mais indicado já que foi criado um novo cliente
	public Cliente adicionar (@RequestBody Cliente cliente) { //anatoção converte o corpo da requisisção que está em JSON no Objeto
		return clienteRespository.save(cliente); //retorna o cliente salvo.
	}
}
