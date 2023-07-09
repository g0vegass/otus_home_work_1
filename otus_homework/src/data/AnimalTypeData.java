package data;

public enum AnimalTypeData {
    CAT("кошка"),
    DOG("собака"),
    DUCK("утка");

    private String name;

    AnimalTypeData(String name){

        this.name = name;
    }
    private String getName(){

        return name;

    }

}
