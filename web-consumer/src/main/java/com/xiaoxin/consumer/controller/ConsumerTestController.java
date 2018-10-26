package com.xiaoxin.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaoxin.consumer.model.UserPayment;
import com.xiaoxin.consumer.service.PayService;
import com.xiaoxin.facade.HelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther zhangyongxin
 * @date 2018/6/3 下午1:28
 */
@RestController
@RequestMapping("hello")
public class ConsumerTestController {
    @Reference(check=false)
    private HelloFacade helloFacade;

    @Autowired
    private PayService payService;

    @GetMapping("/{name}")
    public String hello(@PathVariable String name) {
        return helloFacade.hello(name);
    }


    @PostMapping("/pay")
    public String pay(@RequestBody UserPayment payment){
        try {

            payService.pay(payment);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }
}
