package top.kairecession.demo01.APO;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


// 定义一个切面
@Aspect
@Component
public class demo01 {

    // 每次写porincut太麻烦，把pointcut抽取出来，所以这里只是为了方便execution才这样写，pointCut方法中必须是空的
    @Pointcut("execution(* top.kairecession.demo01.controller..*.*(..)))")
    public void pointCut() {

    }
}
