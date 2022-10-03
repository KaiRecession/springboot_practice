package top.kairecession.demo01.ListenDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import top.kairecession.demo01.User;

import javax.servlet.ServletContext;

@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        UserService userService = applicationContext.getBean(UserService.class);
        User user = userService.getUser();
        System.out.println("监听到User变化");
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("User", user);
    }
}
