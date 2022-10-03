package top.kairecession.demo01.ListenDemo;

import org.springframework.stereotype.Service;
import top.kairecession.demo01.User;

@Service
public class UserService {

    public User getUser() {
        return new User(1, "hao", "wuban", 1.2);
    }


}
