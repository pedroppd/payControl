package br.com.paycontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paycontrol.domain.Company;
import br.com.paycontrol.repository.CompanyRepository;

@Service
public class CompanyService implements PersistData<Company>{

	@Autowired
	private CompanyRepository repository;
	
	public CompanyService() 
	{
		
	}

	@Override
	public List<Company> findAll() 
	{
		return repository.findAll();
	}

	@Override
	public Company findById(Long id) 
	{
		return repository.findById(id).get();
	}

	@Override
	public Company save(Company obj) 
	{
		if(obj != null) 
		{
			return repository.save(obj);
		}
		
		throw new IllegalArgumentException(String.format("The company '%s' is invalid", obj));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
}
