package top.kairecession.demo01.APO;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.kairecession.demo01.error.JsonResult;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class demo02 {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* top.kairecession.demo01.controller..*.*(..)))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("------前置通知进入");

        Signature signature = joinPoint.getSignature();
        String declaringTypeName = signature.getDeclaringTypeName();
        String name = signature.getName();
        logger.info("即将执行方法为:{}, 属于{}包", name, declaringTypeName);

    }

    // returning中的名字要和方法中的一致
    // resutl是未经转化的原方法return结果
    // 直接修改result就可以
    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, JsonResult result) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(result);
        result.setCode("404040404");
    }
}

