// package com.example.spring_boot_practice.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.spring_boot_practice.dto.UserSearchRequest;
// import com.example.spring_boot_practice.entity.User;
// import com.example.spring_boot_practice.repository.UserMapper;

// /**
//  * ユーザー情報 Service
//  */
// @Service
// public class UserService {
//     /**
//      * ユーザー情報 Mapper
//      */
//     @Autowired
//     private UserMapper userMapper;

//     /**
//      * ユーザー情報検索
// 　　　* @param userSearchRequest リクエストデータ
//      * @return 検索結果
//      */
//     public User search(UserSearchRequest userSearchRequest) {
//         return userMapper.search(userSearchRequest);
//     }
// }
