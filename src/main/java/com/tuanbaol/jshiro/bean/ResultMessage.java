package com.tuanbaol.jshiro.bean;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class ResultMessage<T> {
    public String code;
    public T data;
    public String msg;

    public static ResultMessage ok() {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode(String.valueOf(HttpStatus.OK.value()));
        resultMessage.setMsg(HttpStatus.OK.name());
        return resultMessage;
    }

    public static ResultMessage ok(Object data) {
        ResultMessage resultMessage = ok();
        resultMessage.setData(data);
        return resultMessage;
    }

    public static ResultMessage failed() {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        resultMessage.setMsg(HttpStatus.INTERNAL_SERVER_ERROR.name());
        return resultMessage;
    }

    public static ResultMessage failed(String code, String msg) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode(code);
        resultMessage.setMsg(msg);
        return resultMessage;
    }
}
