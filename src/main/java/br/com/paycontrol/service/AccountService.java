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
	public Account save(Account obj) 
	{
		if(obj != null) 
		{
			return repository.save(obj);
		}
		
		throw new IllegalArgumentException(String.format("The account '%s' is invalid", obj));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account update(Long id, Account obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
