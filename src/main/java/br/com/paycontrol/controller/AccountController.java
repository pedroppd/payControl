package br.com.paycontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paycontrol.domain.Account;
import br.com.paycontrol.service.AccountService;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController 
{
	
	@Autowired
	private AccountService accountService;
	
	public AccountController() 
	{
		
	}
	
	@GetMapping
	public ResponseEntity<List<Account>> getAccountes()
	{
		return ResponseEntity.ok().body(accountService.findAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable Long id)
	{
		if(id != null) 
		{
			return ResponseEntity.ok().body(accountService.findById(id));
		}
		
		throw new IllegalArgumentException(String.format("The %s is invalid", id));
	}
}
