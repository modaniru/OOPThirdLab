package org.example.model.entities;

public class ScottishFoldKitten extends ScottishFoldCat{

    ScottishFoldKitten(int age) {
        super(age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("\t Scottish fold kitten is eating");
    }

    public void foolAround(){
        System.out.println("Scottish fold kitten fooling around");
    }
}
