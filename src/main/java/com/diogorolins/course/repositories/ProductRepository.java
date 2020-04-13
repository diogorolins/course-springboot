package com.diogorolins.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogorolins.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
