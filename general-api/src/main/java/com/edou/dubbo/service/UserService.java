package com.edou.dubbo.service;

import com.edou.dubbo.bean.UserAddress;

import java.util.List;

public interface UserService {
    //根据用户id返回用户的地址列表
    List<UserAddress> getUserAddressList(String userId);
}
