package Exercises.Excersie2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Farm {
    private List<Animal> animals;
    public Farm(){
        this.animals = new ArrayList<>();
        initialized_animals();
    }
    private void initialized_animals(){
        Random rand = new Random();
        for(int i=0; i<4;i++){
            myAnimals getAnimal = myAnimals.values()[rand.nextInt(myAnimals.values().length)];
            Animal animal = setInfoAnimal(getAnimal);
            animals.add(animal);
        }
    }
    private Animal setInfoAnimal(myAnimals animalType){
         switch (animalType){
             case CAT:
                 return new Extends_From_Animal.CAT("Female", 7.5);
             case DOG:
                 return new Extends_From_Animal.DOG("Male", 15.0);
             case HORSE:
                 return new Extends_From_Animal.HORSE("Male", 280.0);
             case SHEEP:
                 return new Extends_From_Animal.SHEEP("Female", 32.8);
             default:
                 return (Animal) new IllegalArgumentException("No animal founded!");
         }
    }

    public void Print_Animals (){
        for (Animal s: animals) {
            //System.out.println("Animal ID: " + s.getId());
            System.out.printf("Animal: %s, Gender: %s, Weight: %s KG", s.getClass().getSimpleName(), s.getGender(), s.getWeight());
            System.out.println();
        }
    }
}
