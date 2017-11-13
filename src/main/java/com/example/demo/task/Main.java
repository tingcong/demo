package com.example.demo.task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 多线程任务运行
 * Created by hutingcong on 2017/7/27.
 */
public class Main {
    public static void main(String[] args) {
        schedulerTask();
    }

    //多线程任务
    public static void multipThreadTask(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService=context.getBean(AsyncTaskService.class);
        for (int i = 0; i <10 ; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }

    //定时任务
    public static void schedulerTask(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}
