package org.example.model.entities;

public class Beagle extends Dog{
    public Beagle(int age) {
        super(age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("\tBeagle is eating");
    }
}
