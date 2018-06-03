package com.xiaoxin.service.impl;

import com.xiaoxin.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Auther zhangyongxin
 * @date 2018/6/3 下午1:24
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello:" + name;
    }
}
