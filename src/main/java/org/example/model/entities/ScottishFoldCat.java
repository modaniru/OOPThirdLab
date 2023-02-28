package org.example.model.entities;

public class ScottishFoldCat extends Cat {
    ScottishFoldCat(int age) {
        super(age);
    }

    @Override
    public void eat() {
        System.out.println("Scottish fold cat is eating");
    }
}
