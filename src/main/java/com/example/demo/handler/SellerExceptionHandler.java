package com.example.demo.handler;

import com.example.demo.exception.ResponesBankException;
import com.example.demo.exception.SellException;
import com.example.demo.exception.SellerAuthorizeException;
import com.example.demo.utils.ResultVOUtil;
import com.example.demo.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hutingcong on 2017/11/1.
 */
@ControllerAdvice
public class SellerExceptionHandler {

    //拦截登录异常
    @ExceptionHandler(value =SellerAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorizeExcption(){
        return new ModelAndView("redirect:/common/error");
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerAuthorizeExcption(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = ResponesBankException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public void handlerBankExcption(){

    }
}
