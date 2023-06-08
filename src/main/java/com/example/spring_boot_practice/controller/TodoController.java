package com.example.spring_boot_practice.controller;

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
import org.springframework.web.bind.annotation.RequestParam;


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

  // 追加(未完了タスク一覧にある丸いボタンが押されたら、この処理が実行される)
  @PostMapping("/done")
  public String doneTodo(@RequestParam(name = "id") Integer todoId) {
    Todo updateTodo = todoService.findById(todoId);
    updateTodo.setDone(true);
    todoService.addTodo(updateTodo);
    return "redirect:/";
  }

  // (削除ボタンが押されたら、処理される)
  @PostMapping("/deleteAll")
  public String deleteAll() {
    todoService.deleteAllTodo();
    return "redirect:/";
  }

}