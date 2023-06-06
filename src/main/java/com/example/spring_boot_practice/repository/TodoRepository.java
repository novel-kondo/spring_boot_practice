package com.example.spring_boot_practice.repository;

import com.example.spring_boot_practice.model.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
