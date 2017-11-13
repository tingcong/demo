package com.example.demo.order.enums;

import com.example.demo.enums.CodeEnum;

/**
 * Created by hutingcong on 2017/10/11.
 */
public enum  OrderStatusEnum implements CodeEnum{
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

//    public static OrderStatusEnum getOrderStatusEnum(Integer code){
//        for (OrderStatusEnum orderStatusEnum:OrderStatusEnum.values()){
//            return orderStatusEnum;
//        }
//        return null;
//    }
}
