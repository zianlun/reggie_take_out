package cuit.zian.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@ControllerAdvice(annotations ={Controller.class, RestController.class})
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception){
        log.error(exception.getMessage());
        if(exception.getMessage().contains("Duplicate entry")){
            String[] strs = exception.getMessage().split(" ");
            String msg = "用户【" + strs[2] + "】已经存在";
            return Result.failed(ResultCode.FAILED,msg);
        }
        return Result.failed(ResultCode.FAILED,"系统繁忙，请稍后再试");
    }

    @ExceptionHandler(NullPointerException.class)
    public Result handeleNullPointerException(NullPointerException exception){
        log.error(exception.getMessage());
        return Result.failed(ResultCode.FAILED,"系统繁忙，请稍后再试");
    }

    @ExceptionHandler(CustomException.class)
    public Result handeleCustomException(CustomException exception){
        return Result.failed(exception.getMessage());
    }
}
