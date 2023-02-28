package org.example.model.entities;

public abstract class Cat implements Animal{
    private int age;
    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }
    Cat(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
