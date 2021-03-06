package org.csu.petstore.base;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    private Object datas;

    public ResponseCode responseCode() {
        return ResponseCode.getInstance(this.code);
    }

    public void setResponseCode(ResponseCode responseCode) {
        if (responseCode != null) {
            this.code = responseCode.code();
            this.msg = responseCode.msg();
        }
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static <T> BaseResult<T> getInstance(ResponseCode responseCode) {
        return getInstance(responseCode, null);
    }

    public static <T> BaseResult<T> getInstance(ResponseCode responseCode, Object datas) {
        if (responseCode == null) {
            return null;
        }
        BaseResult<T> baseResult = new BaseResult<T>();
        baseResult.setCode(responseCode.code());
        baseResult.setMsg(responseCode.msg());
        if (datas != null) {
            baseResult.setDatas(datas);
        }
        return baseResult;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
