package top.kairecession.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Animal {

    private Cat cat;

    private Dog hao;

    @Autowired
    public Animal(Cat cat, Dog hao) {
        this.cat = cat;
        this.hao = hao;
        System.out.println("Animal对象开始创建");
    }

    public Animal() {
        System.out.println("iiuhh");
    }

    public Cat getCat() {
        return this.cat;
    }

//    @Autowired
//    public void setCat(Cat cat) {
//        this.cat = cat;
//    }

    public Dog getDog() {
        return this.hao;
    }
}
