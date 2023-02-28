package org.example.model.entities;

public class ScottishFoldCat extends Cat {
    public ScottishFoldCat(int age) {
        super(age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("\tScottish fold cat is eating");
    }
}
