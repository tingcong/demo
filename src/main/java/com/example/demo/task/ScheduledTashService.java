package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计划任务执行类
 * Created by hutingcong on 2017/7/27.
 */
@Service
public class ScheduledTashService {
    private  static final SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");

    /**
     * Scheduled声明该方法是执行任务
     * fixedRate每隔固定时间执行
     */
    @Scheduled(fixedRate=5000)
    public void reportCurrentTime(){
        System.out.println("每隔五秒执行一次"+dateFormat.format(new Date()));
    }

    /**
     * cron按指定时间执行
     */
    @Scheduled(cron = "0 28 11 ? * *")
    public void fixTImeExecution(){
        System.out.println("在指定时间"+dateFormat.format(new Date())+"执行");
    }
}
