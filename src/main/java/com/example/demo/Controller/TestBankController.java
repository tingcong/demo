package com.example.demo.Controller;

import com.example.demo.exception.ResponesBankException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hutingcong on 2017/11/1.
 */
@RestController
@RequestMapping("/bank")
public class TestBankController {

    @RequestMapping("/testException")
    public void test(){
        if(1==1){
            throw new ResponesBankException();
        }
    }
}
