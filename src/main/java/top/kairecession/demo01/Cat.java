package top.kairecession.demo01;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
class Cat extends Dog {
    private String name = "cat";
    private Integer age = 1800;

    public Cat() {
        System.out.println("Cat对象开始创建");
    }

    public String toString() {
        return "Cat{name='" + this.name + "', age=" + this.age + "}";
    }
}
