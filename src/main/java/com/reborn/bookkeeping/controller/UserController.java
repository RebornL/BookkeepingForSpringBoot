package com.reborn.bookkeeping.controller;

import com.reborn.bookkeeping.entity.User;
import com.reborn.bookkeeping.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    
    //登录或注册
    @PostMapping("save")
    public User save(@RequestBody User user) {
        System.out.println(user);
        User exist = userMapper.getUser(user);
        System.out.println(exist);
        //用户不存在，进行注册操作
        if (exist == null) {
            return userMapper.addUser(user);
        }
        //登录密码错误
        if (!exist.getPassword().equals(user.getPassword())) {
            //直接返回原User
            return user;
        }
        //用户ss存在且密码正确
        return exist;
    }
}
