// package com.example.spring_boot_practice.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import lombok.Getter;
// import lombok.Setter;

// @Getter // フィールドのgetメソッド(id, content)を自動生成する
// @Setter // フィールドのsetメソッド(id, content)を自動生成する
// @Entity // データの入れ物であるEntityクラスであることを指定する
// public class Todo {
//   @Id // Entityの主キーを設定する
//   @GeneratedValue // Entityの値を自動採番する
//   private Long id;
//   private String content;
// }

package com.example.spring_boot_practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

// データベースから取得したデータを格納するクラス(登録、更新時の値を保持する)
// データベースの1行に対応した形になっている。
@Entity
@Data
@Table(name = "todolist")
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  @NotBlank
  private String content;

  private boolean done;
}