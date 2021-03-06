package com.reborn.bookkeeping.entity;

public class Config {
    
    private int id;
    private String key;
    private String value;
    private int uid;
    
    public int getUid() {
        return uid;
    }
    
    public void setUid(int uid) {
        this.uid = uid;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "{" +
                "\"id\"=\"" + id +
                "\", \"key\"=\"" + key + '\"' +
                ", \"value\"=\"" + value + '\"' +
                ", \"uid\"=\"" + uid +
                "\"}";
    }
}
