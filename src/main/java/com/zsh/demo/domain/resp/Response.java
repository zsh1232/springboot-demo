package com.yidian.commerce.gemini.domain.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yidian.commerce.gemini.domain.enums.OpenStatus;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenResponse {
    private Integer status;
    private Object data;
    private String error;

    public static OpenResponse ok() {
        return new Builder().status(OpenStatus.OK.getValue()).build();
    }

    public static OpenResponse error() {
       return new Builder().status(OpenStatus.ERROR.getValue()).build();
    }

    public static OpenResponse status(OpenStatus openStatus) {
        return new Builder().status(openStatus.getValue()).build();
    }

    public OpenResponse data(Object data) {
        this.data = data;
        return this;
    }

    public OpenResponse error(String error) {
        this.error = error;
        return this;
    }



    private static class Builder {

        private OpenResponse target;

        Builder() {
            target = new OpenResponse();
        }

        Builder status(Integer status) {
            target.status = status;
            return this;
        }

        public Builder data(Object data) {
            target.data = data;
            return this;
        }

        public Builder error(String error) {
            target.error = error;
            return this;
        }

        OpenResponse build() {
            return target;
        }
    }
}
