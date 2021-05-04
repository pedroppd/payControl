package br.com.paycontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.paycontrol.domain.Client;
import br.com.paycontrol.repository.ClientRepository;
import br.com.paycontrol.service.exception.ResourceIntegrityViolationException;

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
		try 
		{
			repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) 
		{
			throw new ResourceIntegrityViolationException(id);
		}
	}

	@Override
	public Client update(Long id, Client obj) 
	{
		Client client = repository.getOne(id);
		return repository.save(updateData(client, obj));
	}
	
	public Client updateData(Client clientForUpdate, Client clientNewDatas)
	{
		clientForUpdate.setBirthDate(clientNewDatas.getBirthDate());
		clientForUpdate.setCpf(clientNewDatas.getCpf());
		clientForUpdate.setName(clientNewDatas.getName());
		return clientForUpdate;
	}
}
