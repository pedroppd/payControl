package br.com.paycontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paycontrol.domain.Client;
import br.com.paycontrol.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController 
{
	
	@Autowired
	private ClientService clientService;
	
	public ClientController() 
	{
		
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> getClientes()
	{
		return ResponseEntity.ok().body(clientService.findAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id)
	{
		if(id != null) 
		{
			return ResponseEntity.ok().body(clientService.findById(id));
		}
		
		throw new IllegalArgumentException(String.format("The %s is invalid", id));
	}
}
