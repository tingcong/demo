package com.example.demo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by hutingcong on 2017/10/23.
 */
public class GsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson=gsonBuilder.create();
        return gson.toJson(object);
    }
}
