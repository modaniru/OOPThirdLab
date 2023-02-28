package org.example.model.entities;

public class ShibaInu extends Dog{

    public ShibaInu(int age) {
        super(age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("\tShiba Inu is eating");
    }
}
