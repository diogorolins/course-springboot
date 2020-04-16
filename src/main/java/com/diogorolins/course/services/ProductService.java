package com.diogorolins.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.diogorolins.course.entities.Product;
import com.diogorolins.course.repositories.ProductRepository;
import com.diogorolins.course.services.exceptions.DatabaseException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();		
	}
	
	public Product findById(Long id) {
		
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
	public Product insert(Product obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Product update(Long id, Product obj) {
		Product tempProduct = findById(id);
		obj = updateProduct(tempProduct, obj);
		return repository.save(obj);		
	}

	private Product updateProduct(Product tempProduct, Product obj) {
		tempProduct.setName(obj.getName());
		tempProduct.setPrice(obj.getPrice());
		tempProduct.setDescription(obj.getDescription());
		tempProduct.setImgUrl(obj.getImgUrl());
		tempProduct.getCategories().addAll(obj.getCategories());
		return tempProduct;
	}
}
