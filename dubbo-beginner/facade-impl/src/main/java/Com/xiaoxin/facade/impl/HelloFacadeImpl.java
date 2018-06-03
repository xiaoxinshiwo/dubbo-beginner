package Com.xiaoxin.facade.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaoxin.facade.HelloFacade;
import com.xiaoxin.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther zhangyongxin
 * @date 2018/6/3 下午1:26
 */
@Service(interfaceClass = HelloFacade.class)
@Component
public class HelloFacadeImpl implements HelloFacade {

    @Autowired
    private HelloService helloService;

    public String hello(String name) {
        return helloService.hello(name);

    }
}
