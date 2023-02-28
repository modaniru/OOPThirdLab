package org.example.model.entities;

public class ScottishFoldKitten extends ScottishFoldCat{

    public ScottishFoldKitten(int age) {
        super(age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("\t\tScottish fold kitten is eating");
    }

    public void foolAround(){
        System.out.println("Scottish fold kitten fooling around");
    }
}
