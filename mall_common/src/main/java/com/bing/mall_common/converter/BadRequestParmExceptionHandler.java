/*
package com.bing.mall_common.converter;

import com.bing.mall_common.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

*/
/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/11 8:54
 *//*

@RestControllerAdvice
public class BadRequestParmExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(BadRequestParmExceptionHandler.class);

    */
/**
     *  校验错误拦截处理
     *
     * @param exception 错误信息集合
     * @return 错误信息
     *//*

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result validationBodyException(MethodArgumentNotValidException exception){

        BindingResult result = exception.getBindingResult();
        StringBuilder errorMsg = new StringBuilder() ;
        if (result.hasErrors()) {

            List<ObjectError> errors = result.getAllErrors();

            errors.forEach(p ->{

                FieldError fieldError = (FieldError) p;
                logger.error("Data check failure : object{"+fieldError.getObjectName()+"},field{"+fieldError.getField()+
                        "},errorMessage{"+fieldError.getDefaultMessage()+"}");
                errorMsg.append(p.getDefaultMessage()).append("!");

            });

        }
        return Result.fail(errorMsg.toString());
    }

}
*/
