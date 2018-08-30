package com.reborn.bookkeeping.controller;

import com.reborn.bookkeeping.entity.Record;
import com.reborn.bookkeeping.mapper.RecordMapper;
import com.reborn.bookkeeping.util.Consume;
import com.reborn.bookkeeping.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("record")
public class RecordController {
    
    @Autowired
    private RecordMapper recordMapper;
    
    //获取本月的消费
    @RequestMapping("getConsume")
    public Consume getMonthConsume(@RequestParam("uid") int uid) {
        Date monthegin = DateUtil.monthBegin();
        Date today = DateUtil.today();
        Consume consume = recordMapper.getMonthConsume(uid, monthegin, today);
        System.out.println(consume);
        if (consume == null) {
            consume.setUid(uid);
            consume.setConsume(0);
        }
        return consume;
    }
    
    //获取本月记录
    @RequestMapping("getMonthRecord")
    public List<Record> getMonthRecord(@RequestParam("uid") int uid) {
        return recordMapper.getRecordSegment(uid, DateUtil.monthBegin(),
                DateUtil.today());
    }
    
    @PostMapping("addRecord")
    public int addRecord(@RequestBody Record record) {
        System.out.println(record);
        return recordMapper.addRecord(record);
    }
}
