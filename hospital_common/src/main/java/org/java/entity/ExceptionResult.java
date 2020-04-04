package org.java.entity;

import org.java.enums.HospitalEnum;

import java.util.Date;

public class ExceptionResult {
    private int code;
    private String msg;
    private Date date;



    public ExceptionResult(HospitalEnum hospitalEnum) {
        this.code = hospitalEnum.getCode();
        this.msg = hospitalEnum.getMsg();
        this.date = new Date();
    }

    public ExceptionResult(){

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
