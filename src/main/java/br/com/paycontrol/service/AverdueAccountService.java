package br.com.paycontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paycontrol.domain.AverdueAccount;
import br.com.paycontrol.repository.AverdueAccountRepository;

@Service
public class AverdueAccountService implements PersistData<AverdueAccount>{

	@Autowired
	private AverdueAccountRepository repository;
	
	public AverdueAccountService() 
	{
		
	}

	@Override
	public List<AverdueAccount> findAll() 
	{
		return repository.findAll();
	}

	@Override
	public AverdueAccount findById(Long id) 
	{
		return repository.findById(id).get();
	}

	@Override
	public boolean save(AverdueAccount obj) 
	{
		if(obj != null) 
		{
			repository.save(obj);
			return true;
		}
		
		throw new IllegalArgumentException(String.format("The company '%s' is invalid", obj));
	}
}
