package com.diogorolins.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogorolins.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
