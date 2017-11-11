package com.shenghe.common.entity;

/**
 * Created by zl-h on 2017/5/23.
 */
public class HttpResult<T> extends BaseEntity{

    private Integer code;

    private String message;

    private T data;

    private Long count;


    public HttpResult() {
    }

    public HttpResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public HttpResult(Long count, T data) {
        this.count = count;
        this.data = data;
        this.code = 0;
    }

    public static HttpResult newInstance(Integer code,String message,Object data){
        return new HttpResult(code,message,data);
    }

    public static HttpResult getDataList(Long iTotalRecords,Object data){
        return new HttpResult(iTotalRecords,data);
    }

    /**
     * 返回错误信息
     * @param message
     * @param data
     * @return
     */
    public static HttpResult getErrorMessage(String message,Object data){
        return newInstance(-100,message,data);
    }

    public static HttpResult getSuccessfulResult(Object data){
        return newInstance(0,"success",data);
    }

    public static HttpResult getFailureResult(Object data){
        return newInstance(-100,"failure",data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
