package top.kairecession.demo01.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kairecession.demo01.Hobby;
import top.kairecession.demo01.StudentMapper;

@Controller
public class hello {
    @Autowired
    StudentMapper studentMapper;

    public hello() {
    }

    @RequestMapping({"/hello"})
    @ResponseBody
    public List<Hobby> hello() {
        return this.studentMapper.gets(1);
    }
}