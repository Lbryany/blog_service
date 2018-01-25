package org.bryanzzz.dto;

public class BlogResult<T> {

    private Integer code;

    private T data;

    private String msg;

    public BlogResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public BlogResult(Integer code, String error) {
        this.code = code;
        this.msg = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
