package com.diogorolins.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.diogorolins.course.entities.Category;
import com.diogorolins.course.repositories.CategoryRepository;
import com.diogorolins.course.services.exceptions.DatabaseException;
import com.diogorolins.course.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();		
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Category insert(Category obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		Category obj = findById(id);
		try {
			repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Category update(Long id, Category obj) {
		Category tempCategory = findById(id);
		obj = updateCategory(tempCategory, obj);
		return repository.save(obj);	
	}

	private Category updateCategory(Category tempCategory, Category obj) {
		tempCategory.setName(obj.getName());
		return tempCategory;
	}

}
