package Lesson_03.Task4;

import java.io.Serializable;

public class Human implements Serializable {
    private String name;
    private String soname;
    private int age;

    private transient Human friend;

    public Human(String name, String soname, int age) {
        this.name = name;
        this.soname = soname;
        this.age = age;
    }

    public void getInfo(){
        System.out.println(name + " " + soname + " - возраст " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human getFriend() {
        return friend;
    }

    public void setFriend(Human friend) {
        this.friend = friend;
    }
}
