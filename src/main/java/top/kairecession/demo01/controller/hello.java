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
import top.kairecession.demo01.StudentMapper;
import top.kairecession.demo01.User;
import top.kairecession.demo01.dao.UserMapper;

@RestController
@Api(value = "Swagger22222 在线接口文档")
public class hello {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    UserMapper userMapper;

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



}