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
		if(repository.findById(id).isPresent()) 
		{
			return repository.findById(id).get();
		}
		return null;
	}

	@Override
	public AverdueAccount save(AverdueAccount obj) 
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
