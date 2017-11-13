package com.example.demo;

import com.example.demo.entity.Person;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.entity.sell.mapper")	//使用mybatis时配置扫描mapper文件
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/index")
	public String hello(Model model){
		Person single=new Person("aa",11);
		List<Person> people=new ArrayList<>();
		people.add(new Person("xx",11));
		people.add(new Person("yy",22));
		people.add(new Person("zz",33));
		model.addAttribute("singlePerson",single);
		model.addAttribute("people",people);
		return "index";
	}

	@RequestMapping("/")
	public String index(Model model) {
		Person single = new Person("aa", 11);
		List<Person> people = new ArrayList<>();
		people.add(new Person("xx", 11));
		people.add(new Person("yy", 22));
		people.add(new Person("zz", 33));
		model.addAttribute("singlePerson", single);
		model.addAttribute("people", people);
		return "index";
	}
}
