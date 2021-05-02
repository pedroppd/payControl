package br.com.paycontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paycontrol.domain.Company;
import br.com.paycontrol.service.CompanyService;

@RestController
@RequestMapping(value = "/accounts")
public class CompanyController 
{
	
	@Autowired
	private CompanyService companyService;
	
	public CompanyController() 
	{
		
	}
	
	@GetMapping
	public ResponseEntity<List<Company>> getCompanyes()
	{
		return ResponseEntity.ok().body(companyService.findAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id)
	{
		if(id != null) 
		{
			return ResponseEntity.ok().body(companyService.findById(id));
		}
		
		throw new IllegalArgumentException(String.format("The %s is invalid", id));
	}
}
