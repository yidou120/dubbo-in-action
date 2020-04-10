package com.edou.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

// 1.springboot+dubbo 使用@Service暴露服务,@Refrence引用服务,@EnableDubbo和application.xml写相关配置
// 2.如果使用原生的xml整合,就不需要使用@Service暴露服务,因为xml里面配置了暴露服务,也不需要使用@EnableDubbo注解
// 但是需要使用@ImprtResource注解指定配置文件的位置 application.xml也不用写配置了
// 3.使用注解api/java config的形式
//@EnableDubbo
//@ImportResource(locations = "provider.xml")
@EnableDubbo(scanBasePackages = "com.edou.dubbo")
@EnableHystrix
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
