package top.kairecession.demo01;

import java.io.Serializable;

public class Hobby implements Serializable {
    private int id;
    private String name;
    private String hobby;

    public Hobby() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return this.hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String toString() {
        return "Hobby{id=" + this.id + ", name=" + this.name + ", hobby='" + this.hobby + "'}";
    }
}