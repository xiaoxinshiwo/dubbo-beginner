package com.xiaoxin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaoxin.facade.HelloFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther zhangyongxin
 * @date 2018/6/3 下午1:28
 */
@RestController
@RequestMapping("hello")
public class ConsumerTestController {
    @Reference(check=true)
    private HelloFacade helloFacade;

    @GetMapping("/{name}")
    public String hello(@PathVariable String name) {
        return helloFacade.hello(name);
    }
}
