package com.example.spring_boot_practice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter // フィールドのgetメソッド(id, content)を自動生成する
@Setter // フィールドのsetメソッド(id, content)を自動生成する
@Entity // データの入れ物であるEntityクラスであることを指定する
public class Todo {
  @Id // Entityの主キーを設定する
  @GeneratedValue // Entityの値を自動採番する
  private Long id;
  private String content;
}