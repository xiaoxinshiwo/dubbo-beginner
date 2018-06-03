package com.xiaoxin;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther zhangyongxin
 * @date 2018/6/3 下午1:18
 */
@SpringBootApplication
@EnableDubboConfiguration
@ComponentScan("com.xiaoxin")
public class Consumer {

    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }
}
