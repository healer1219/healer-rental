package com.healer.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.function.Consumer;

/**
 * 数据响应对象
 *    {
 *      success ：是否成功
 *      code    ：返回码
 *      message ：返回信息
 *      //返回数据
 *      data：  ：{
 *
 *      }
 *    }
 */
@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
public class Result<T> {

    private boolean success;//是否成功
    private Integer code;//返回码
    private String message;//返回信息
    private T data;//返回数据

    public Result(ResultCode code) {
        this.success = code.success;
        this.code = code.code;
        this.message = code.message;
    }

    public Result(ResultCode code,T data) {
        this.success = code.success;
        this.code = code.code;
        this.message = code.message;
        this.data = data;
    }

    public Result(Integer code,String message,boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }



    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(ResultCode.FAIL, data);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(ResultCode.FAIL.code(), message, false);
    }


    public static <T> Result<T> SUCCESS(){
        return new Result<>(ResultCode.SUCCESS);
    }

    public static  <T> Result<T> ERROR(){
        return new Result<>(ResultCode.SERVER_ERROR);
    }

    public static <T> Result<T> FAIL(){
        return new Result<>(ResultCode.FAIL);
    }

    public void ifSuccess() {

    }

    public boolean checkSuccess() {
        return Boolean.TRUE.equals(this.success);
    }


    public void ifSuccess(Consumer<? super T> action) {
        if (success) {
            action.accept(data);
        }
    }
}
