package com.reborn.bookkeeping.util;

public class Consume {
    private int uid;
    private int consume;
    
    public int getUid() {
        return uid;
    }
    
    public void setUid(int uid) {
        this.uid = uid;
    }
    
    public int getConsume() {
        return consume;
    }
    
    public void setConsume(int consume) {
        this.consume = consume;
    }
    
    @Override
    public String toString() {
        return "Consume{" +
                "uid=" + uid +
                ", consume=" + consume +
                '}';
    }
}
