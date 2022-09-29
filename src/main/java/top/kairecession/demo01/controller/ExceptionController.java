package top.kairecession.demo01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.kairecession.demo01.error.JsonResult;

@Controller
@ResponseBody
@RequestMapping("/exception")
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @PostMapping(value = "/test")
    public JsonResult test(@RequestParam("name") String name,
                           @RequestParam("pass") String pass) {
        System.out.println(24434324);
        logger.info("name：{}", name);
        logger.info("pass：{}", pass);
        return new JsonResult();
    }
}

