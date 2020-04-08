package com.edou.dubbo.controller;

import com.edou.dubbo.bean.UserAddress;
import com.edou.dubbo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName OrderController
 * @Description Order控制层
 * @Author 中森明菜
 * @Date 2020/4/8 19:58
 * @Version 1.0
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/list")
    public List<UserAddress> list(@RequestParam("uid") String userId){
        List<UserAddress> userAddresses = orderService.initOrder(userId);
        return userAddresses;
    }
}
