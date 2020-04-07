package com.edou.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @ClassName MainApplication
 * @Description 启动类
 * @Author 中森明菜
 * @Date 2020/4/7 22:09
 * @Version 1.0
 */
public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("provider.xml");
        ctx.start();
        System.in.read();
    }
}
