package com.example.demo.task;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by hutingcong on 2017/7/27.
 */
@Configuration
@ComponentScan("com.example.demo.task")
//@EnableScheduling   //开启对计划任务的支持
public class TaskSchedulerConfig {
}
