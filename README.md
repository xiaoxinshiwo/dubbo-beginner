#dubbo-beginner
1. 使用dubbo-spring-boot-starter
2. 常规项目既是服务提供方又是服务消费方
3. 使用dubbo-spring-boot-starter 1.0.2版本，2.0.0版本有问题orz
4. 发布服务和使用服务的分别注解为：
```java
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.annotation.Reference;
```
5. 一般来说consumer和不会作为子module消费自己发布的服务，而是通过内部service依赖调用
本例中有web-consumer module仅仅为了测试需要；
也可以使用命令测试服务启动情况：
```
$ telnet 127.0.0.1 20881
Trying 127.0.0.1...
Connected to localhost.
Escape character is '^]'.

dubbo>ls
com.xiaoxin.facade.HelloFacade
dubbo>

```
6. 除了web-consumer为消费端完整的web工程其他module属于provider  
7. 启动顺序：provider >  consumer  
8、消息机制，确保数据的最终一致性；需要安装rocketmq4.3
