package com.hualuo.ch7_2;

/**
 * Model Class Person
 *
 * @author Joseph
 * @create 2017/10/25 23:27
 */
public class Person {

    private String name;

    private Integer age;

    public Person() {
        super();
    }

    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
