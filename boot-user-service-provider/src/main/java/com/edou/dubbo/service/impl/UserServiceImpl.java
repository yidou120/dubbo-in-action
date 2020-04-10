package com.edou.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.edou.dubbo.bean.UserAddress;
import com.edou.dubbo.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description UserService实现类
 * @Author 中森明菜
 * @Date 2020/4/7 20:05
 * @Version 1.0
 */
@Service(version = "1.0.0")
@Component
public class UserServiceImpl implements UserService {

    @Override
    @HystrixCommand
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
        if(Math.random()>0.5){
            throw new RuntimeException();
        }
        return Arrays.asList(address1,address2);
    }
}
