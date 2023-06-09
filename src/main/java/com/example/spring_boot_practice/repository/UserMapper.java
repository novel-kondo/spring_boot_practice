package com.example.spring_boot_practice.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.spring_boot_practice.dto.UserSearchRequest;
import com.example.spring_boot_practice.entity.User;

/**
 * ユーザー情報 Mapper
 */
@Mapper
public interface UserMapper {
    /**
     * ユーザー情報検索
     * @param user 検索用リクエストデータ
     * @return ユーザー情報
     */
    User search(UserSearchRequest user);
}
