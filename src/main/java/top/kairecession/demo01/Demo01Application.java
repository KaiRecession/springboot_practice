package top.kairecession.demo01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@ServletComponentScan
@MapperScan({"top.kairecession.demo01.dao", "top.kairecession.demo01"})
public class Demo01Application {
    public Demo01Application() {
        System.out.println("fdsafdsafd");
    }


    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(Demo01Application.class, args);
//        Dog dog = run.getBean("hao", Dog.class);
//        Animal animal = run.getBean("animal", Animal.class);
        System.out.println(run.getBean("fix"));
//        System.out.println(animal.getCat());
//        person person = run.getBean("person", person.class);
//        System.out.println(person);
//        System.out.println(dog);
    }
}
