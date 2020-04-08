package com.edou.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.edou.dubbo.bean.UserAddress;
import com.edou.dubbo.service.OrderService;
import com.edou.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Reference
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id："+userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : addressList) {
            System.out.println(userAddress.getUserAddress());
        }
        return addressList;
    }
}
