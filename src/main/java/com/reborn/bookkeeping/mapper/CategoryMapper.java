package com.reborn.bookkeeping.mapper;

import com.reborn.bookkeeping.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CategoryMapper {
    
    @Select("SELECT * FROM category")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "uid", column = "uid")
    })
    List<Category> getAll();
    
    @Select("SELECT * FROM category where uid = #{uid}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "uid", column = "uid")
    })
    List<Category> getCategoryByUid(int id);
    
    @Insert("INSERT into category(id, name, uid) VALUES(#{id}, #{name}, " +
            "#{uid})")
    void add(Category category);
    
    @Delete("DELETE FROM category WHERE id =#{id} and uid = #{uid}")
    int delete(@Param("id") int id, @Param("uid") int uid);
    //Delete要加上@Param才能获取参数
}
