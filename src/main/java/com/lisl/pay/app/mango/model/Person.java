package com.lisl.pay.app.mango.model;

public class Person {
    private String id;

    private String sex;

    private Integer age;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}