package org.example.model.utils;

import org.example.model.Container;
import org.example.model.entities.*;

import java.util.Random;

public class AnimalGenerator {
    private final Random random = new Random();
    public Container<Animal> generateAnimals(int count) {
        Container<Animal> container = new Container<>();
        generateDogs(count/2, container);
        generateCats(count/2, container);
        return container;
    }

    private void generateDogs(int count, Container<Animal> container) {
        for (int i = 0; i < count; i++) {
            int type = random.nextInt(0, 2);
            Random random1  = new Random();
            int age = random1.nextInt(0, 10);
            if(type == 0){
                container.add(new Beagle(age));
            }
            else{
                container.add(new ShibaInu(age));
            }
        }
    }
    private void generateCats(int count, Container<Animal> container){
        for (int i = 0; i < count; i++) {
            int type = random.nextInt(0, 3);
            if(type == 0 && container.getSize() > 0){
                container.add(new MeiKun(random.nextInt(0,10)), random.nextInt(0, container.getSize()));
            }
            else if(type == 1){
                container.addFirst(new ScottishFoldCat(random.nextInt(0,10)));
            }
            else {
                container.add(new ScottishFoldKitten(1));
            }
        }
    }
}
