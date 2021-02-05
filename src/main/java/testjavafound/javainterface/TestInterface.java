package main.java.testjavafound.javainterface;

import java.util.Scanner;

public class TestInterface implements I1,I2{

    public static void main(String[] args) {
        new TestInterface().f();
    }

    @Override
    public void f() {
        System.out.println("dddddd");
    }
}

interface I1 {
    void f();
}

interface I2 {
    void f();
}
