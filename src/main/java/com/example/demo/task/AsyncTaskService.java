package com.example.demo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 多线程任务执行类
 * Created
 * by hutingcong on 2017/7/27.
 */
@Service
public class AsyncTaskService {

    @Async  //表明该方法是异步方法
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务："+(i));
    }


    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1："+(i+1));
    }
}
