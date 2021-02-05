package main.java.testjavafound.exception;


import java.util.List;

public class ClassCasts {

    public static void main(String[] args) {
        Building building = new Building();
        Building b = new House();
        Class<House> houseType = House.class;
        Class<? super House> superclass = houseType.getSuperclass();
        House h = houseType.cast(b);
        h = (House) b;
        if( building instanceof House );
//            ((House) building).bark();

    }

}

class Building {
}

class House extends Building {
}
