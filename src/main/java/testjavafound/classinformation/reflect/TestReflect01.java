package main.java.testjavafound.classinformation.reflect;


import typeinfo.pets.Cat;
import typeinfo.pets.Pet;

public class TestReflect01 {

    public static void aa(Pet  pet) {

        System.out.println("是否检测出pet的类型 = " + pet.getClass());
    }

    public static void main(String[] args) {
        Pet cat = new Cat();
        aa(cat);
    }

}