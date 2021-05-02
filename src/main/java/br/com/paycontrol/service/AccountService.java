package br.com.paycontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paycontrol.domain.Account;
import br.com.paycontrol.repository.AccountRepository;

@Service
public class AccountService implements PersistData<Account>{

	@Autowired
	private AccountRepository repository;
	
	public AccountService() 
	{
		
	}

	@Override
	public List<Account> findAll() 
	{
		return repository.findAll();
	}

	@Override
	public Account findById(Long id) 
	{
		return repository.findById(id).get();
	}

	@Override
	public boolean save(Account obj) 
	{
		if(obj != null) 
		{
			repository.save(obj);
			return true;
		}
		
		throw new IllegalArgumentException(String.format("The company '%s' is invalid", obj));
	}
}
