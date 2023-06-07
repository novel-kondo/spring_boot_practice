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



import javax.validation.Valid;
import java.util.List;

import com.example.spring_boot_practice.service.TodoService;
import com.example.spring_boot_practice.model.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TodoController {

  @Autowired
  TodoService todoService;

  @GetMapping("/")
  public String home(Model model) {
    List<Todo> allTodo = todoService.searchAll();
    model.addAttribute("allTodo", allTodo);
    model.addAttribute("todo", new Todo()); // 追加：新しいTodoオブジェクトをviewに引き渡す(th:objectで受け取る)
    return "home";
  }

  // 追加(formのth:actionと結びついている)
  @PostMapping("/")
  public String createTodo(@Valid Todo todo, BindingResult bindingResult,Model model) {
    // 入力値にエラーがあった時
    if(bindingResult.hasErrors()) {
      List<Todo> allTodo = todoService.searchAll();
      model.addAttribute("allTodo", allTodo);
      model.addAttribute("todo", todo);
      return "home";
    }

    // エラーがなかった時は、Todoを新規登録する
    todoService.addTodo(todo);
    return "redirect:/";
  }  
}