package com.yetta.pilipili.util;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回类
 *
 * @author yetta
 */
public class Result {

    private String code;        //状态码 000000:成功 999999:失败

    private String message;     //提示信息

    private Map<String,Object> data=new HashMap<>();    //用户返回给浏览器的数据

    public static Result success(){
        Result result=new Result();
        result.setCode("000000");
        result.setMessage("操作成功!");
        return result;
    }

//             StringUtils.isEmpty(null)      = true
//             StringUtils.isEmpty("")        = true
//             StringUtils.isEmpty(" ")       = false
//             StringUtils.isEmpty("bob")     = false
//             StringUtils.isEmpty("  bob  ") = false

    public static Result error(String message){
        Result result=new Result();
        result.setCode("999999");
        if (StringUtils.isEmpty(message)){
            result.setMessage("操作失败!");
        }else {
            result.setMessage(message);
        }
        return result;
    }

    //链式操作返回信息
    public Result add(String key,Object value){
        this.data.put(key, value);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
