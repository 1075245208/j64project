package org.java.shopping.ov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FileOV {
        private int code;//状态码： 1：成功  0：失败
        private String msg;//文件上传成功或失败的提示信息
        private String data;//文件上传成功后的保存路径


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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public FileOV(int code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public FileOV(){

    }
}
