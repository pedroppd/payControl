package br.com.paycontrol.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Client> save(@RequestBody Client client)
	{
		if(client != null) 
		{
			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(client.getId()).toUri();
			return ResponseEntity.created(uri).body(client);
		}
		
		throw new IllegalArgumentException(String.format("The %s is invalid", client));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		if(id != null) 
		{
			clientService.delete(id);
			ResponseEntity.noContent().build();
		}
		
		throw new IllegalArgumentException(String.format("The value '%s' cannot be null", id));
	}
}
