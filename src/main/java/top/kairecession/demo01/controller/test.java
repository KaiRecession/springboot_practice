package top.kairecession.demo01.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.kairecession.demo01.actor;

@RestController
@Api(tags = "我是test",description = "test的描述")
public class test {
    private final static Logger logger = LoggerFactory.getLogger(test.class);
    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public actor getactor() {
        logger.debug("访问test01了");
        logger.info("访问test01了");
        return new actor();
    }
}
