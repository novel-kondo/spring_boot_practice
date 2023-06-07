package com.example.spring_boot_practice.service;

import java.util.List;

import com.example.spring_boot_practice.model.Todo;
import com.example.spring_boot_practice.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// DBとの具体的な処理(データの取得、新規作成など)を記述するクラス
@Service
public class TodoService {

  @Autowired
  TodoRepository todoRepository;

  public List<Todo> searchAll() {
    return todoRepository.findAll();
  }

  // Todoを新たにDBに登録する
  public void addTodo(Todo todo) {
    todoRepository.save(todo);
  }
}