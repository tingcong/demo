package com.example.demo.entity;

import java.io.Serializable;

/**
 * Created by hutingcong on 2017/7/27.
 */
public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Person() {
        super();
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
