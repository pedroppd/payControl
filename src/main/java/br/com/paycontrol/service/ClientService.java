package br.com.paycontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paycontrol.domain.Client;
import br.com.paycontrol.repository.ClientRepository;

@Service
public class ClientService implements PersistData<Client>{

	@Autowired
	private ClientRepository repository;
	
	public ClientService() 
	{
		
	}

	@Override
	public List<Client> findAll() 
	{
		return repository.findAll();
	}

	@Override
	public Client findById(Long id) 
	{
		return repository.findById(id).get();
	}

	@Override
	public Client save(Client obj) 
	{
		if(obj != null) 
		{
			return repository.save(obj);
		}
		
		throw new IllegalArgumentException(String.format("The cliente '%s' is invalid", obj));
	}

	@Override
	public void delete(Long id) 
	{
		repository.deleteById(id);
	}
}
