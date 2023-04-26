package cuit.zian.reggie;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
@MapperScan("cuit.zian.reggie.mapper")
@ServletComponentScan(basePackages = "cuit.zian.reggie")
public class ReggieTakeOutApplication {
    public static void main(String[] args) {
        ApplicationContext run  = SpringApplication.run(ReggieTakeOutApplication.class, args);
    }

}
