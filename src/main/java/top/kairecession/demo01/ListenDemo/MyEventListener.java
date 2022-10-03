package top.kairecession.demo01.ListenDemo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import top.kairecession.demo01.User;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

    public void onApplicationEvent(MyEvent myEvent) {
        User user = myEvent.getUser();
        System.out.println(user.getName() + "1111111");
    }
}
