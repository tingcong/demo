package com.example.demo.jpa;

/**
 * Created by hutingcong on 2017/7/30.
 */

import com.example.demo.jpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    //spring data jap已自动注册bean，所以可以自动注入
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name, String address, Integer age){
        Person p=personRepository.save(new Person(null,name,age,address));
        return p;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address){
        List<Person> people=personRepository.findByAddress(address);
        return people;
    }

    @RequestMapping("/q2")
    public Person q2(String name,String address){
        Person p= (Person) personRepository.findByNameAndAddress(name,address);
        return  p;
    }

    @RequestMapping("/q3")
    public Person q3(String name,String address){
        Person p=personRepository.withNameAndAddressQuery(name,address);
        return p;
    }

    @RequestMapping("/q4")
    public  List<Person> q4(String name,String address){
//        Person p= (Person) personRepository.withNameAndAddressNamedQuery(name,address);
        List<Person> people= personRepository.withNameAndAddressNamedQuery(name,address);
        return people;
    }

    /**
     * 测试排序
     * @return
     */
    @RequestMapping("/sort")
    public List<Person> sort(){
        List<Person> people=personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return people;
    }

    /**
     * 测试分页
     */
    @RequestMapping("/page")
    public Page<Person> page(){
        Page<Person> pagePeople=personRepository.findAll(new PageRequest(1,2));
        return pagePeople;
    }
}
