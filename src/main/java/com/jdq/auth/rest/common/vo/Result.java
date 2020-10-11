package com.jdq.auth.rest.common.vo;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private String code;
    private String msg;
    private T data;

    public Result() {

    }

    public Result(T obj) {
        this.setCode(ResultCode.SUCCESS.getCode());
        this.setMsg(ResultCode.SUCCESS.getMsg());
        this.setData(obj);
    }

    public static Result boolResult(boolean success) {
        return success ? successRet(null) : failRet();
    }

    public static <T> Result<T> boolResult(boolean success, T data, String msg) {
        return success ? successRet(data) : failRet(msg);
    }

    public static Result boolResult(boolean success, BaseResultCode code) {
        return success ? successRet() : failRet(code);
    }

    public static Result successRet() {
        Result res = new Result();
        res.setCode(ResultCode.SUCCESS.getCode());
        res.setMsg(ResultCode.SUCCESS.getMsg());
        return res;
    }

    public static <T> Result<T> successRet(T obj) {
        Result<T> res = new Result<T>();
        res.setCode(ResultCode.SUCCESS.getCode());
        res.setMsg(ResultCode.SUCCESS.getMsg());
        res.setData(obj);
        return res;
    }

    public static Result failRet() {

        Result res = new Result();
        res.setCode(ResultCode.GATEWAY_ERROR.getCode());
        res.setMsg(ResultCode.GATEWAY_ERROR.getMsg());
        return res;
    }

    public static Result failRet(BaseResultCode code) {
        Result res = new Result();
        res.setCode(code.getCode());
        res.setMsg(code.getMsg());
        return res;
    }

    public static Result failRet(String msg) {
        Result res = new Result();
        res.setCode(ResultCode.GATEWAY_ERROR.getCode());
        res.setMsg(msg);
        return res;
    }

    public static Result failRet(BaseResultCode code, String msg) {
        Result res = new Result();
        res.setCode(code.getCode());
        res.setMsg(msg);
        return res;
    }

    public static Result failRet(String code, String msg) {
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        return res;
    }

    public boolean ifSucceed() {
        return StrUtil.equals(ResultCode.SUCCESS.getCode(), this.code);
    }

    public static boolean isOK(Result json) {
        return StrUtil.equals(ResultCode.SUCCESS.getCode(), json.getCode());
    }
}
