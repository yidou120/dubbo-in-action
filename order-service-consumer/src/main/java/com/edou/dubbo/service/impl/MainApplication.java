package com.edou.dubbo.service.impl;

import com.edou.dubbo.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @ClassName MainApplication
 * @Description 启动类
 * @Author 中森明菜
 * @Date 2020/4/7 22:17
 * @Version 1.0
 */
public class MainApplication {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.initOrder("1");
        System.in.read();
    }
}
