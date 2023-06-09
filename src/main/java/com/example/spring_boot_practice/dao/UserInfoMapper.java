package com.example.spring_boot_practice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.spring_boot_practice.dto.UserAddRequest;
import com.example.spring_boot_practice.dto.UserSearchRequest;
import com.example.spring_boot_practice.dto.UserUpdateRequest;
import com.example.spring_boot_practice.entity.UserInfo;

/**
 * ユーザー情報 Mapper
 */
@Mapper
public interface UserInfoMapper {

    /**
     * ユーザー情報全件検索
     * @param user 検索用リクエストデータ
     * @return 検索結果
     */
    List<UserInfo> findAll();

    /**
     * ユーザー情報主キー検索
     * @param id 主キー
     * @return 検索結果
     */
    UserInfo findById(Long id);

    /**
     * ユーザー情報検索
     * @param user 検索用リクエストデータ
     * @return 検索結果
     */
    List<UserInfo> search(UserSearchRequest user);

    /**
     * ユーザー情報登録
     * @param userRequest 登録用リクエストデータ
     */
    void save(UserAddRequest userRequest);

    /**
     * ユーザー情報更新
     * @param userUpdateRequest 更新用リクエストデータ
     */
    void update(UserUpdateRequest userUpdateRequest);

    /**
     * ユーザー情報の論理削除
     * @param id ID
     */
    void delete(Long id);
}
