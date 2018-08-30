package com.reborn.bookkeeping.mapper;

import com.reborn.bookkeeping.entity.Record;
import com.reborn.bookkeeping.util.Consume;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface RecordMapper {
    
    //获取本月的总消费金额
    @Select("SELECT uid, sum(spend) as 'consume' from record where uid = #{uid}" +
            " and date > #{monthbegin} and date < #{today}")
    @Results({
            @Result(property = "uid", column = "uid"),
            @Result(property = "consume", column = "consume")
    })
    Consume getMonthConsume(@Param("uid") int uid, @Param("monthbegin") Date
            monthbegin, @Param("today") Date today);
    
    //获取记录
    @Select("select * from record where date >= #{datebegin} and date <= " +
            "#{dateend} " +
            "and " +
            "uid = " +
            "#{uid} order by date")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "cid", column = "cid"),
            @Result(property = "spend", column = "spend"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "comment", column = "comment"),
            @Result(property = "date", column = "date", javaType = java.util
                    .Date.class)
    })
    List<Record> getRecordSegment(@Param("uid") int uid, @Param("datebegin")
            Date datebegin, @Param("dateend") Date dateend);
    
    @Select("select * from record where date = #{today} and uid = " +
            "#{uid} order by date")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "cid", column = "cid"),
            @Result(property = "spend", column = "spend"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "comment", column = "comment"),
            @Result(property = "date", column = "date", javaType = java.util
                    .Date.class)
    })
    List<Record> getRecordToday(int uid, Date today);
 
    //增加记录
    @Insert("INSERT into record(spend, cid, uid, comment, date) values( " +
            "#{spend}, #{cid}, #{uid}, #{comment}, #{date})")
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "cid", column = "cid"),
//            @Result(property = "spend", column = "spend"),
//            @Result(property = "uid", column = "uid"),
//            @Result(property = "comment", column = "comment"),
//            @Result(property = "date", column = "date", javaType = java.util
//                    .Date.class)
//    })
    int addRecord(Record record);
    
    //删除记录
    @Delete("DELETE FROM record WHERE id =#{id} and uid = #{uid}")
    int delete(@Param("id") int id, @Param("uid") int uid);
}
