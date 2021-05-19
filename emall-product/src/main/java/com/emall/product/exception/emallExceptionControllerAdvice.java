package com.emall.product.exception;

import com.common.exception.BizCodeEnume;
import com.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//集中处理所有异常

@Slf4j
@RestControllerAdvice(basePackages = "com.emall.product.controller")
public class emallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e){
        log.error("数据校验出现问题{}，异常类型：{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();

        Map<String,String> erroMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError)->{
            erroMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return R.error(BizCodeEnume.VALID_EXCEPTION.getCode(),BizCodeEnume.VALID_EXCEPTION.getMsg()).put("data",erroMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(){
        return R.error(BizCodeEnume.UNKNOW_EXEPTION.getCode(),BizCodeEnume.UNKNOW_EXEPTION.getMsg());
    }

}

