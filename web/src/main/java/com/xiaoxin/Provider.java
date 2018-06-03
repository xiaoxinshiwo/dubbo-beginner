package com.xiaoxin;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther zhangyongxin
 * @date 2018/6/3 下午1:18
 */
@SpringBootApplication
@EnableDubboConfiguration
public class Provider {

    public static void main(String[] args) {
        SpringApplication.run(Provider.class, args);
    }
}
