package org.example;

import org.example.model.Container;
import org.example.model.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //показ функционала объекта каждого из классов
//        MeiKun meiKun = new MeiKun(10);
//        meiKun.eat();
//        ScottishFoldCat scottishFoldCat = new ScottishFoldCat(10);
//        scottishFoldCat.eat();
//        ScottishFoldKitten scottishFoldKitten = new ScottishFoldKitten(1);
//        scottishFoldKitten.eat();
//        scottishFoldKitten.foolAround();
//        ShibaInu shibaInu = new ShibaInu(10);
//        shibaInu.eat();
//        Hatiko hatiko = new Hatiko(10);
//        hatiko.eat();
//        hatiko.waiting();
        
        Container<Animal> animalContainer = new Container<>();
//        generateAnimal(100, animalContainer);
//        //т.к контейнер у нас содержит Animal, следовательно только методы интерфейса Animal будут доступны его объектам
        animalContainer.clear();
        checkTime(() -> {
            generateAnimal(100, animalContainer);
            animalContainer.forEach((animal) -> {
                animal.eat();
            });
        });
        animalContainer.clear();
        checkTime(() -> {
            generateAnimal(1000, animalContainer);
            animalContainer.forEach((animal) -> {
                animal.eat();
            });
        });
        animalContainer.clear();
        checkTime(() -> {
            generateAnimal(10000, animalContainer);
            animalContainer.forEach((animal) -> {
                animal.eat();
            });
        });
    }

    public static void checkTime(Runnable runnable){
        Long start = System.currentTimeMillis();
        runnable.run();
        System.out.println("time: " + (System.currentTimeMillis() - start)/1000.0 + "s");
    }

    public static void generateAnimal(int count, Container<Animal> container){
        Random random = new Random();
        container.addFirst(new Hatiko(10));
        for (int i = 0; i < count; i++) {
            int choice = random.nextInt(0, 3);
            if(choice == 0){
                generateScottish(container, random);
            } else if (choice == 1) {
                generateMeiKun(container, random);
            }
            else {
                generateShibaInu(container, random);
            }
        }
    }

    public static void generateScottish(Container<Animal> container, Random random){
        int year = random.nextInt(1, 10);
        if(year == 1){
            container.add(new ScottishFoldKitten(year), random.nextInt(0, container.getSize()));
        }
        else{
            container.add(new ScottishFoldCat(year), random.nextInt(0, container.getSize()));
        }
    }

    public static void generateMeiKun(Container<Animal> container, Random random){
        container.add(new MeiKun(random.nextInt(1, 10)), random.nextInt(0, container.getSize()));
    }
    
    public static void generateShibaInu(Container<Animal> container, Random random){
        container.add(new ShibaInu(random.nextInt(1, 10)), random.nextInt(0, container.getSize()));
    }
}
