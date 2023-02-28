package org.example.model.entities;

public class MeiKun extends Cat{

    public MeiKun(int age) {
        super(age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("\tMei Kun is eating");
    }
}
