package com.example.demo.jpa;

import com.example.demo.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 数据访问接口
 * Created by hutingcong on 2017/7/30.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {

    //使用方法名查询
    List<Person> findByAddress(String name);

    //使用方法名查询
    Person findByNameAndAddress(String name,String address);

    //使用@Query查询，参数按名称绑定
    @Query("select p from Person p where p.name=:name and p.address=:address")
    Person withNameAndAddressQuery(@Param("name")String name, @Param("address")String address);

    //使用NamedQuery查询（实体类中定义的@NameQuery）
    List<Person> withNameAndAddressNamedQuery(String name,String address);
}
