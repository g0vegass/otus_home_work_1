package factory;

import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalTypeData;

import java.util.Locale;

public class AnimalFactory {

    public Animal create(String animalType) {

        boolean isAnimalExist = false;

        for (AnimalTypeData animalTypeData : AnimalTypeData.values()) {
            if (animalTypeData.name().equals(animalType.trim().toUpperCase(Locale.ROOT))) {
                isAnimalExist = true;
                break;
            }
        }

        if (!isAnimalExist) {
            System.out.println(String.format("Животное %s не поддерживается", animalType));
            return null;
        }

        AnimalTypeData animalTypeData = AnimalTypeData.valueOf(animalType.trim().toUpperCase(Locale.ROOT));


        switch (animalTypeData) {
            case CAT: {
                return new Cat();
            }
            case DOG: {
                return new Dog();
            }
            case DUCK: {
                return new Duck();
            }


        }

        return new Duck();
    }
}