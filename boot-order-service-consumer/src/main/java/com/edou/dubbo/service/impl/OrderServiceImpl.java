package com.edou.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.edou.dubbo.bean.UserAddress;
import com.edou.dubbo.service.OrderService;
import com.edou.dubbo.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description OrderService实现类
 * @Author 中森明菜
 * @Date 2020/4/7 20:08
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

//    @Autowired
    //使用dubbo的注解 让他调用接口对应的暴露方法
//    @Reference(url = "127.0.0.1:20890",loadbalance = "roundrobin") //使用dubbo直连的方式 可以不需要注册中心
    @Reference(version = "1.0.0")
    UserService userService;

    @Override
    @HystrixCommand(fallbackMethod = "reliable")
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id："+userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : addressList) {
            System.out.println(userAddress.getUserAddress());
        }
        return addressList;
    }

    public List<UserAddress> reliable(String userId){
        System.out.println("hystrix...");
        return Arrays.asList(new UserAddress(6,"test","6","test","test","test"));
    }
}
