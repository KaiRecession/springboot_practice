package top.kairecession.demo01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.kairecession.demo01.User;
import top.kairecession.demo01.dao.UserMapper;

import java.util.List;

@Service
public class demo03 {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAll() {
        return userMapper.getUser();
    }
}
