package com.nacosstu.nacosdemo;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true)
@EnableSwagger2
public class NacosDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDemoApplication.class, args);
    }

}
