package com.wm.gameplat.config.exception;

public class RunningException extends RuntimeException{

    private String msg;

    public RunningException(String msg){
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
