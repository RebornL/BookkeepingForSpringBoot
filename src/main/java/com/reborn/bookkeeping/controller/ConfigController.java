package com.reborn.bookkeeping.controller;

import com.reborn.bookkeeping.entity.Config;
import com.reborn.bookkeeping.mapper.ConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("config")
public class ConfigController {
    
    @Autowired
    private ConfigMapper configMapper;
    
    @RequestMapping("getConfig")
    public List<Config> getConfigByUid(@RequestParam("uid") int uid) {
        return configMapper.getConfigByUid(uid);
    }
    
    @PostMapping("save")
    public int saveConfig(@RequestParam("buget")
                          String buget, @RequestParam("uid") int uid) {
        Config config = new Config();
        config.setUid(uid);
        config.setKey("buget");//设置预算
        config.setValue(buget);
        return configMapper.insertConfig(config);
    }
}
