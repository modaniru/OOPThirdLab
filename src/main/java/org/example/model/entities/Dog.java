package org.example.model.entities;

public abstract class Dog implements Animal{
    private int age;
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    public Dog(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
