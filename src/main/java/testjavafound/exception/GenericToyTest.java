package main.java.testjavafound.exception;

public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        Object obj = up.newInstance();
        System.out.println(fancyToy);
        System.out.println(obj);
    }
}

class CCC {

}

class FancyToy extends CCC {

}
