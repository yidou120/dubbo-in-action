package com.edou.dubbo.service.impl;

import com.edou.dubbo.bean.UserAddress;
import com.edou.dubbo.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description UserService实现类
 * @Author 中森明菜
 * @Date 2020/4/7 20:05
 * @Version 1.0
 */
public class UserServiceImpl2 implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("retry...");
        System.out.println("new version...");
        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(address1,address2);
    }
}
