package org.example.model;

import org.example.model.entities.Animal;
import org.example.model.entities.Dog;
import org.example.model.utils.AnimalGenerator;
import org.example.model.utils.ExecutionTime;

public class Example {
    public static void main(String[] args) {
        AnimalGenerator animalGenerator = new AnimalGenerator();
        Container<Animal> animalContainer = animalGenerator.generateAnimals(100);
        ExecutionTime.checkTime(() -> {
            for (Animal animal : animalContainer) {
                animal.eat();
            }
        });
        ExecutionTime.checkTime(() -> {
            for (int i = 0; i < animalContainer.getSize(); i++) {
                if(animalContainer.get(i) instanceof Dog){
                    animalContainer.deleteAt(i);
                    i--;
                }
            }
        });
        System.out.println(animalContainer.getSize());
    }//csdweqwdaseqw
}
