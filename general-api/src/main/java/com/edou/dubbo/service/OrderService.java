package com.edou.dubbo.service;

import com.edou.dubbo.bean.UserAddress;

import java.util.List;

public interface OrderService {
    //初始化订单
    List<UserAddress> initOrder(String userId);
}
