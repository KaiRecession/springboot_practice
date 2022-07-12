package top.kairecession.demo01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("hao")
@Scope("prototype")
public class Dog {
    @Value("woc")
    private String name;
    @Value("18")
    private Integer age;

    public Dog() {
        System.out.println("Dog 对象开始创建");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Dog{name='" + this.name + "', age=" + this.age + "}";
    }
}
