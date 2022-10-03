package top.kairecession.demo01.ListenDemo;

import org.springframework.context.ApplicationEvent;
import top.kairecession.demo01.User;

public class MyEvent extends ApplicationEvent {
    private User user;

    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
