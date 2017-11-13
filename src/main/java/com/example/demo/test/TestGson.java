package com.example.demo.test;

import com.example.demo.order.dataobject.OrderDetail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by hutingcong on 2017/10/12.
 */
public class TestGson {
    public static void convert(){
        String tmp="[{productId:123456,productQuantity:2}]";
        Gson gson=new Gson();
        List<OrderDetail> result=gson.fromJson(tmp,
                new TypeToken<List<OrderDetail>>() {}.getType());
        System.out.println("11");
    }

    public static void main(String[] args) {
        convert();
    }
}
