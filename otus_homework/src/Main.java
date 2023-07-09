import animals.Animal;
import data.ComandsData;
import factory.AnimalFactory;
import tools.NumberTools;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Введите одну из команд add/list/exit");

            String commandStr = scanner.next();
            String commandStrForComparison = commandStr.trim().toUpperCase(Locale.ROOT);

            boolean isExist = false;

            for (ComandsData comandsData : ComandsData.values()) {
                if (comandsData.name().equals(commandStrForComparison)) {
                    isExist = true;
                    break;
                }
            }


            if (!isExist) {
                System.out.println(String.format("Команда %s не поддерживается", commandStr));
                continue;
            }


            ComandsData comandsData = ComandsData.valueOf(commandStrForComparison);


            switch (comandsData) {
                case ADD: {
                    System.out.println("Введите одно из животных cat,dog,duck");

                    String animalStr = scanner.next();

                    AnimalFactory animalFactory = new AnimalFactory();
                    Animal animal = animalFactory.create(animalStr);


                    while (animal == null) {
                        System.out.println("Вы ввели не верны тип животнго");
                        animalStr = scanner.next();
                        animal = animalFactory.create(animalStr);

                    }
                    animals.add(fillAnimalData(animal));
                    break;
                }

                case LIST: {
                    for (Animal animal : animals) {
                        System.out.println(animal.toString());
                    }
                    break;
                }
                case EXIT: {
                    System.exit(0);
                }

            }

        }
    }

    private static Animal fillAnimalData(Animal animal){
        System.out.println("Введите имя животного");
        animal.setName(scanner.next());


        Integer age = 0;
        do {
            System.out.println("Введите возраст животного");


            age = NumberTools.convertStringToInt(scanner.next());

            if(age != null) {
                break;
            }
            System.out.println("Возраст введён неверно");
        }while(true);

        animal.setAge(age);


        Integer weight;
        do{
        System.out.println("Введите вес животного в кг");

        weight = NumberTools.convertStringToInt(scanner.next());

            if(weight != null) {
                break;
            }
            System.out.println("Возраст введён неверно");
        }while(true);

        animal.setWeight(weight);



        System.out.println("Введите цвет животного");
        animal.setColor(scanner.next());

        return animal;
    }

}
