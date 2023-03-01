package org.example.model;

import org.example.model.entities.Animal;
import org.example.model.entities.Dog;
import org.example.model.entities.Hatiko;
import org.example.model.utils.AnimalGenerator;
import org.example.model.utils.ExecutionTime;

public class Example {
    public static void main(String[] args) {
        AnimalGenerator animalGenerator = new AnimalGenerator();
        Container<Animal> animalContainer = animalGenerator.generateAnimals(100);
        ExecutionTime.checkTime(() -> {
            animalContainer.forEach(Animal::eat);
        });
//        ExecutionTime.checkTime(() ->{
//            for (Integer i = 0; i < animalContainer.getSize(); i++) {
//                if(animalContainer.get(i) instanceof Dog){
//                    animalContainer.deleteAt(i);
//                    i--;
//                }
//            }
//        });
//        ExecutionTime.checkTime(() -> {
//            animalContainer.forEach(Animal::eat);
//        });
//        System.out.println(animalContainer.getSize());
    }
}
