package com.zsh.demo.domain.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zsh.demo.domain.enums.RespStatus;
import lombok.Data;

import static com.zsh.demo.domain.enums.RespStatus.OK;
import static com.zsh.demo.domain.enums.RespStatus.ERROR;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private Integer status;
    private Object data;
    private String msg;

    public static Response ok() {
        return new Builder().status(OK.getValue()).msg(OK.getDesc()).build();
    }

    public static Response error() {
       return new Builder().status(ERROR.getValue()).msg(ERROR.getDesc()).build();
    }

    public static Response status(RespStatus status) {
        return new Builder().status(status.getValue()).msg(status.getDesc()).build();
    }

    public Response data(Object data) {
        this.data = data;
        return this;
    }

    public Response msg(String msg) {
        this.msg = msg;
        return this;
    }

    private static class Builder {

        private Response target;

        Builder() {
            target = new Response();
        }

        Builder status(Integer status) {
            target.status = status;
            return this;
        }

        public Builder data(Object data) {
            target.data = data;
            return this;
        }

        Builder msg(String msg) {
            target.msg = msg;
            return this;
        }

        Response build() {
            return target;
        }
    }
}
