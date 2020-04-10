package com.diogorolins.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogorolins.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
