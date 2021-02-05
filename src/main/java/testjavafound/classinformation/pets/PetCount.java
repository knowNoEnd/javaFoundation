package main.java.testjavafound.classinformation.pets;

//: typeinfo/PetCount.java
// Using instanceof.
import typeinfo.pets.*;
import typeinfo.pets.Dog;
import typeinfo.pets.ForNameCreator;
import typeinfo.pets.Manx;
import typeinfo.pets.Mouse;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;
import typeinfo.pets.PetCreator;
import typeinfo.pets.Pug;
import typeinfo.pets.Rat;
import typeinfo.pets.Rodent;

import java.util.*;
import static main.java.testjavafound.net.mindview.util.Print.*;

public class PetCount {
    static class PetCounter extends HashMap<String,Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if(quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1);
        }
    }
    public static void
    countPets(PetCreator creator) {
        PetCounter counter= new PetCounter();
        for(typeinfo.pets.Pet pet : creator.createArray(20)) {
            // List each individual pet:
            printnb(pet.getClass().getSimpleName() + " ");
            if(pet instanceof Pet) {
                counter.count("Pet");
                System.out.println(pet.getClass().hashCode());
                System.out.println(Pet.class.hashCode());
            }

//            if(pet instanceof Dog)
//                counter.count("Dog");
//            if(pet instanceof Mutt)
//                counter.count("Mutt");
//            if(pet instanceof Pug)
//                counter.count("Pug");
//            if(pet instanceof Cat)
//                counter.count("Cat");
//            if(pet instanceof typeinfo.pets.Manx)
//                counter.count("EgyptianMau");
//            if(pet instanceof typeinfo.pets.Manx)
//                counter.count("Manx");
//            if(pet instanceof Manx)
//                counter.count("Cymric");
//            if(pet instanceof Rodent)
//                counter.count("Rodent");
//            if(pet instanceof Rat)
//                counter.count("Rat");
//            if(pet instanceof Mouse)
//                counter.count("Mouse");
//            if(pet instanceof Hamster)
//                counter.count("Hamster");
        }
        // Show the counts:
        print();
        print(counter);
    }
    public static void main(String[] args) {
        countPets(new ForNameCreator()
        );
    }
}
