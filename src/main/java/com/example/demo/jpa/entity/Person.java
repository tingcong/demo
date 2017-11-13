package com.example.demo.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * hibernate支持自动将实体类映射为数据表格
 * Created by hutingcong on 2017/7/30.
 */
@Entity //指明这是个和数据表映射的实体类
@NamedQuery(name = "Person.withNameAndAddressNamedQuery",query = "select p from Person p where p.name=?1 and p.address=?2")
public class Person {
    @Id     //指明这个属性映射为数据库的主键
    @GeneratedValue //默认使用主键生成方式为自增，hibernate会为我们自动生成一个名为HIBERNATE_SEQUENCE的序列
    private Long ID;
    private String name;
    private Integer age;
    private String address;

    public Person(Long ID, String name, Integer age, String address) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public Person() {
        super();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
