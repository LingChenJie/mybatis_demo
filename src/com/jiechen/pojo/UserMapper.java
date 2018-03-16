package com.jiechen.pojo;

import java.util.List;

public interface UserMapper {

    /**
     * 根据id查询
     */
    User queryUserById(int id);

    /**
     * 根据用户名查询用户
     */
    List<User> queryUserByUsername(String username);

    /**
     * 根据用户名查询用户
     */
    List<User> queryUserByUsername2(String username);

    /**
     * 保存用户
     */
    void saveUser(User user);

    /**
     * 根据id更新用户
     */
    void updateUserById(User user);

    /**
     * 根据id删除用户
     */
    void deleteUserById(int id);
}
