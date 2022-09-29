package top.kairecession.demo01;

public class User {
    int id;
    String name;
    String classes;
    double grade;

    public User(int id, String name, String classes, double grade) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
