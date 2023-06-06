package com.example.spring_boot_practice.controller;

// import com.example.spring_boot_practice.model.Todo;
// import com.example.spring_boot_practice.repository.TodoRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;

// @RequiredArgsConstructor
// @Controller
// public class TodoController {

//   private final TodoRepository repository;

//   //  Read
//   @GetMapping("/")
//   public String showAllTodo(@ModelAttribute Todo todo, Model model) {
//     model.addAttribute("todos", repository.findAll()); 
//     return "index";
//   }

//   //  Create
//   @PostMapping("/add")
//   public String addTodo(@ModelAttribute Todo todo) {
//     repository.save(todo);
//     return "redirect:/";
//   }

//   //  Update
//   @PostMapping("/edit")
//   public String editTodo(@ModelAttribute Todo todo) {
//     repository.save(todo);
//     return "redirect:/";
//   }

//   //  Delete
//   @GetMapping("/delete/{id}")
//   public String deleteTodo(@PathVariable Long id) { 
//     repository.deleteById(id);
//     return "redirect:/";
//   }
// }




import java.util.List;

import com.example.spring_boot_practice.service.TodoService;
import com.example.spring_boot_practice.model.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TodoController {

  @Autowired
  TodoService todoService;

  @GetMapping("/")
  public String home(Model model) {
    List<Todo> allTodo = todoService.searchAll();
    model.addAttribute("allTodo", allTodo);
    return "home";
  }
}