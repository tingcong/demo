package com.example.demo.order.enums;

import com.example.demo.enums.CodeEnum;

/**
 * Created by hutingcong on 2017/10/11.
 */
public enum PayStatusEnum implements CodeEnum{
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

//    public static PayStatusEnum getPayStatusEnum(Integer code){
//        for (PayStatusEnum payStatusEnum:PayStatusEnum.values()){
//            return payStatusEnum;
//        }
//        return null;
//    }
}
