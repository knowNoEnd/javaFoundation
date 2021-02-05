//: typeinfo/pets/Pets.java
// Facade to produce a default PetCreator.
package main.java.testjavafound.classinformation.pets;

import typeinfo.pets.LiteralPetCreator;
import typeinfo.pets.Pet;
import typeinfo.pets.PetCreator;

import java.util.ArrayList;

public class Pets {
  public static final PetCreator creator =
    new LiteralPetCreator();
  public static Pet randomPet() {
    return creator.randomPet();
  }
  public static Pet[] createArray(int size) {
    return creator.createArray(size);
  }
  public static ArrayList<Pet> arrayList(int size) {
    return creator.arrayList(size);
  }
} ///:~
