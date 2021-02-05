package main.java.testjavafound.exception;

import org.junit.Test;
import sun.plugin2.message.transport.SerializingTransport;

public class TestException {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
            System.out.println("-------------------");
            System.err.println(System.out);
            System.out.println(System.out);

        }
    }
}

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}

class TestException1 extends Exception {
    TestException1() {}
    TestException1(String ss) {
        super(ss);
    }
}
