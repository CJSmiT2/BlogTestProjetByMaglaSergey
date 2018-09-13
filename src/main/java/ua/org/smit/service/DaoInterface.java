package ua.org.smit.service;

import java.io.Serializable;
import java.util.List;


public interface DaoInterface<T, Id extends Serializable> {

	public int write(T entity);
	
	public void update(T entity);
	
	public T getById(int id);
	
	public void delete(T entity);
	
	public List<T> getAll();
        
        public List<T> findAll(String search);
}