package com.sy.admin;


import com.sy.sycommon.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 言曌
 * @date 2018/7/29 下午9:23
 */

public interface UserService {
    /**
     * 根据用户ID获得用户信息
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable("id") Integer id);

    /**
     * 获得所有的用户
     * @return
     */
    @GetMapping("/user")
    List<User> listUsers();

    /**
     * 根据用户ID删除用户
     * @param id
     */
    @DeleteMapping("/user/{id}")
    void deleteUserById(@PathVariable("id") Integer id);

    /**
     * 更新用户
     * @param user
     */
    @PutMapping("/user")
    void updateUser(@RequestBody User user);

    /**
     * 添加新用户
     * @param user
     */
    @PostMapping("/user")
    User insertUser(@RequestBody User user);
}

