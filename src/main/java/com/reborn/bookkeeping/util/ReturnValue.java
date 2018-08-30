package com.reborn.bookkeeping.util;

import java.io.Serializable;

public class ReturnValue implements Serializable {
    
    private int error;
    
    public int getError() {
        return error;
    }
    
    public void setError(int error) {
        this.error = error;
    }
}
