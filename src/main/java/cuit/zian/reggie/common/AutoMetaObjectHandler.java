package cuit.zian.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

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
        log.info("【insertFill】执行{}",metaObject.toString());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("【updateFill】执行{}", metaObject.toString());
    }
}
