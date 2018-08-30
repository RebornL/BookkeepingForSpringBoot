package com.reborn.bookkeeping.mapper;

import com.reborn.bookkeeping.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    
    @Select("SELECT  * from user where username = #{username}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    })
    User getUser(User user);
    
    @Insert("insert into user(id, username, password) values" +
            "(#{id}, #{username}, #{password})")//需要把所有的字段属性填进去，否则会报错，除非单独传参进去
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    })
    User addUser(User user);
}
