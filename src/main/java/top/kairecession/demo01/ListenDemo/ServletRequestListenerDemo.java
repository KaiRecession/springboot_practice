package top.kairecession.demo01.ListenDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

@Component
public class ServletRequestListenerDemo implements ServletRequestListener {

    private static final Logger logger = LoggerFactory.getLogger(ServletRequestListenerDemo.class);

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        logger.info("session id为：{}", request.getRequestedSessionId());
        logger.info("request url为：{}", request.getRequestURL());
        System.out.println("session id为：{}" + request.getRequestedSessionId());
        System.out.println("session url为：{}" + request.getRequestURL());

        request.setAttribute("name", "woc");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        logger.info("request end");
        System.out.println("request end");
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        logger.info("request域中保存的name值为：{}", request.getAttribute("name"));
        System.out.println("request域中保存的name值为：" + request.getAttribute("name"));

    }


}
