//: typeinfo/pets/Pet.java
package main.java.testjavafound.classinformation.pets;

import typeinfo.pets.Individual;

public class Pet<T> extends Individual {
  public Pet(String name) { super(name); }
  public Pet() { super(); }
} ///:~
