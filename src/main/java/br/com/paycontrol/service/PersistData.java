package br.com.paycontrol.service;

import java.util.List;

public interface PersistData<T> 
{	
	public List<T> findAll();
	
	public T findById(Long id);
	
	public T save(T obj);
	
	public void delete(Long id);
	
	public T update(Long id, T obj);
}
