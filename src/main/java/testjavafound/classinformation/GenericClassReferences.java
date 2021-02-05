package main.java.testjavafound.classinformation;

public class GenericClassReferences {

    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        // 为通配符创建一个范围
        Class<? extends Number> genericIntClass1 = int.class;
        genericIntClass = Integer.class;
    }

}
