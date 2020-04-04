package org.java.entity;

import lombok.Data;

import java.util.List;

/**
 * 该类，用于保存分页的结果
 */

public class PageResult<T> {

    private List<T> data;//保存分页查询到的结果
    private int code;//状态码，0：表示正常
    private String msg="";//数据无法加载时，显示的消息内容
    private Long count;//查询到的数据总数

    private Integer pageNum;
    private Integer maxPage;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
