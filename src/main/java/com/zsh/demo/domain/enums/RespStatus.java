package com.zsh.demo.domain.enums;


public enum RespStatus {
    /**
     * 错误码
     * 10 类别 001详细
     */
    OK(0, "成功"),
    ERROR(-1, "失败");

    private int value;
    private String desc;

    RespStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
