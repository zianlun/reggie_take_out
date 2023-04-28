package cuit.zian.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName AutoMetaObjectHandler
 * @Description
 * @Author ljzhang
 * @Date 2023/4/26 17:05
 * @Version 1.0
 */
@Component
@Slf4j
public class AutoMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("【线程{}】的【insertFill方法】执行{}",Thread.currentThread(),metaObject.toString());
        log.info("employeeId:   {}",BaseContext.getCurrentId());
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser",BaseContext.getCurrentId());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("【updateFill】执行{}", metaObject.toString());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }
}
