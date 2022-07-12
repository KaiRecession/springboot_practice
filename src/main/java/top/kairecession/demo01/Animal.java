package top.kairecession.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Animal {
    @Autowired
    private Cat cat;
    @Autowired
    private Dog hao;

    public Animal() {
        System.out.println("Animal对象开始创建");
    }

    public Cat getCat() {
        return this.cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return this.hao;
    }
}
