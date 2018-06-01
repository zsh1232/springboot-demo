package com.yidian.commerce.gemini.domain.enums;

public enum OpenStatus {
    OK(0),                              //0:成功
    ERROR(1024),                        //1024:失败

    //用户对接
    USER_EXISTS(100),                   //用户存在
    USER_NO_EXISTS(101),                //用户不存在
    USER_UPDATE_FAIL(102),              //用户更新失败
    USER_PARAM_ILLEGAL(103),            //用户参数不合法

    //媒体对接
    MEDIA_EXISTS(200),                  //媒体存在
    MEDIA_NO_EXISTS(201),               //媒体不存在
    MEDIA_UPDATE_FAIL(202),             //用户更新失败
    MEDIA_PARAM_ILLEGAL(203),           //媒体参数不合法

    //广告位
    SLOTS_NO_EXISTS(300),               //广告位不存在
    SLOTS_EXISTS(301),               //广告位存在



    SETTLEMENT_PARAM_ILLEGAL(403),           //结算参数不合法


    //系统错误
    SYS_DB_ERR(500),                    //数据库连接错误
    SYS_DB_CNN_ERR(501),                //数据库连接错误
    SYS_DB_ID_OUT_RANGE(502);                //数据库连接错误




    private int value;

    OpenStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
