package top.kairecession.demo01.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.kairecession.demo01.Hobby;
import top.kairecession.demo01.ListenDemo.UserService2;
import top.kairecession.demo01.StudentMapper;
import top.kairecession.demo01.User;
import top.kairecession.demo01.dao.UserMapper;
import top.kairecession.demo01.service.demo03;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "Swagger22222 在线接口文档")
public class hello {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    demo03 userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService2 userService2;

    public hello(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public List<Hobby> hello() {
        return this.studentMapper.gets(1);
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1() {
        return "this.studentMapper.gets(1)";
    }


    public String hello2(@PathVariable Integer id, @PathVariable String name, @RequestParam(defaultValue = "genderss") @ApiParam("性别") String gender) {
        return name + id + gender;
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public user hello3(@RequestBody user user) {
        return user;
    }

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    public List<User> hello4() {
        return userMapper.getUser();
    }

    @RequestMapping(value = "/hello5/{id}", method = RequestMethod.GET)
    public Integer hello5(@PathVariable Integer id) {
        return userMapper.insertUser(new User(id, "woc", "五班", 10.9));
    }

    @RequestMapping(value = "/hello6/{id}", method = RequestMethod.GET)
    public void hello6(@PathVariable Integer id) {
        userService.isertUser(new User(id, "woc", "五班", 10.9));
    }

    @GetMapping("/hello7/Listen")
    public User getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        System.out.println((User) application.getAttribute("User"));
        User user = (User)application.getAttribute("User");
        user.setGrade(1000.00);
        application.setAttribute("User", user);
        return (User) application.getAttribute("User");
    }

    @GetMapping("/hello8/Listen")
    public String getTotalUser(HttpServletRequest request) {
        Integer count = (Integer)request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    @GetMapping("/hello9")
    public String getRequestInfo(HttpServletRequest request) {
        System.out.println("requestListener中的初始化的name数据：" + request.getAttribute("name"));
        return "success";
    }

    @GetMapping("/hello10")
    public User publishEvent() {
        return userService2.getUser();
    }

    @GetMapping("/hello11")
    public String hello11() {
        return "hello";
    }


}