package br.com.paycontrol.service;

import java.util.List;

public interface PersistData<T> 
{	
	public List<T> findAll();
	
	public T findById(Long id);
	
	public boolean save(T obj);
}