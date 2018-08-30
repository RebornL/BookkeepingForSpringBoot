package com.reborn.bookkeeping.mapper;

import com.reborn.bookkeeping.entity.Config;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ConfigMapper {
    
    @Select("SELECT * FROM config WHERE uid = #{uid}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "key", column = "key"),
            @Result(property = "value", column = "value"),
            @Result(property = "uid", column = "uid")
    })
    List<Config> getConfigByUid(int uid);
    
    @Insert("INSERT INTO config(id, key, value, uid) VALUES(#{id}, #{key}, " +
            "#{value}, #{id})")
    int insertConfig(Config config);
}
