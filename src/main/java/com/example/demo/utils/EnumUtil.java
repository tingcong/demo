package com.example.demo.utils;

import com.example.demo.enums.CodeEnum;

/**
 * Created by hutingcong on 2017/10/28.
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each:enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
