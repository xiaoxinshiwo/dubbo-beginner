package com.xiaoxin.consumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Auther zhangyongxin
 * @date 2018/6/3 下午1:18
 */
@SpringBootApplication(scanBasePackages = "com.xiaoxin.consumer")
@EnableDubboConfiguration
@MapperScan("com.xiaoxin.consumer.mapper")
public class Consumer {

    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }
}
