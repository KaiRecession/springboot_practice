package top.kairecession.demo01.ListenDemo;


import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import top.kairecession.demo01.User;

import javax.annotation.Resource;

@Service
public class UserService2 {
    @Resource
    private ApplicationContext applicationContext;

    public User getUser() {
        User user = new User(1, "woc", "fdsa", 102.2);
        MyEvent myEvent = new MyEvent(this, user);
        // 自己发布这个事件，然后让事件被触发
        applicationContext.publishEvent(myEvent);
        return user;
    }
}
