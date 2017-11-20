package com.hualuo.ch7_7;

/**
 * 传值对象Java Bean
 *
 * @author Joseph
 * @create 2017/11/15 20:31
 */
public class Person {

    private String name;

    private  Integer age;

    private String address;

    public Person() {
        super();
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
