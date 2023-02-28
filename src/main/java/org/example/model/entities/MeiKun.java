package org.example.model.entities;

public class MeiKun extends Cat{

    public MeiKun(int age) {
        super(age);
    }

    @Override
    public void eat() {
        System.out.println("Mei Kun is eating");
    }
}
