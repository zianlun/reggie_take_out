package cuit.zian.reggie.common;


import lombok.Data;

/**
 *
 * @param <T>
 */
@Data
public class Result<T> {

    /*
    *  状态码
    *  响应信息
    *  返回数据
    *  自定义数据
    * */
    private Integer code;

    private String msg;

    private T data;


    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),data);
    }

    public static <T> Result<T> success(String msg, T data){
        return new Result<T>(ResultCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> Result<T> success(String msg){
        return new Result<T>(ResultCode.SUCCESS.getCode(), msg, null);
    }

    public static <T> Result<T> failed(ResultCode code) {
        return new Result(code.getCode(), code.getMsg(), null);
    }

    public static <T> Result<T> failed(ResultCode code, String msg) {
        return new Result<>(code.getCode(), msg, null);
    }

    public static <T> Result<T> failed(String msg) {
        return new Result<>(ResultCode.FAILED.getCode(), msg, null);
    }

    //服务器内部错误
    public static <T> Result<T> failed() {
        return Result.failed(ResultCode.FAILED);
    }

    //参数检验错误
    public static <T> Result<T> validateFailed() {
        return Result.failed(ResultCode.VALIDATE_FAILED);
    }

    //未登录 token过期
    public static <T> Result<T> unauthorized() {
        return Result.failed(ResultCode.UNAUTHORIZED);
    }

    public static <T> Result<T> unauthorized(String msg) {
        return Result.failed(ResultCode.UNAUTHORIZED, msg);
    }

    //权限错误
    public static <T> Result<T> forbidden() {
        return Result.failed(ResultCode.FORBIDDEN);
    }

    public static <T> Result<T> forbidden(String msg) {
        return Result.failed(ResultCode.FORBIDDEN, msg);
    }

    //资源不存在
    public static <T> Result<T> notFound() {
        return Result.failed(ResultCode.NOT_FOUND);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
