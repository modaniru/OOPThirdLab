package org.example.model.entities;

public class Hatiko extends ShibaInu{
    public Hatiko(int age) {
        super(age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Hatiko is eating");
    }

    public void waiting(){
        System.out.println("Hatiko is waiting...");
    }
}
