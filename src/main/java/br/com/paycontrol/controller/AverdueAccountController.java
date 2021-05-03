package br.com.paycontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paycontrol.domain.AverdueAccount;
import br.com.paycontrol.service.AverdueAccountService;

@RestController
@RequestMapping(value = "/averdueAccounts")
public class AverdueAccountController 
{
	
	@Autowired
	private AverdueAccountService averdueAccountService;
	
	public AverdueAccountController() 
	{
		
	}
	
	@GetMapping
	public ResponseEntity<List<AverdueAccount>> getAverdueAccountes()
	{
		return ResponseEntity.ok().body(averdueAccountService.findAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<AverdueAccount> getAverdueAccountById(@PathVariable Long id)
	{
		if(id != null) 
		{
			return ResponseEntity.ok().body(averdueAccountService.findById(id));
		}
		
		throw new IllegalArgumentException(String.format("The %s is invalid", id));
	}
}
