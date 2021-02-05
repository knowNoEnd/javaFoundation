package main.java.testjavafound.Internal;

public class TestBiBao {
    public static void main(String[] args) {
        Callee1 callee1 = new Callee1();
        Callee2 callee2 = new Callee2();
//        MyIncrement.f(callee2);
        Caller caller1 = new Caller(callee1);
        Caller caller2 = new Caller(callee2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }

}

interface  Incrementable {
    // 增量方法
    void increment();
}

class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }

}

class MyIncrement {
    public void increment() {
        System.out.println("Other operation");
    }

    // 静态方法
    static void f(MyIncrement mi) {
        mi.increment();
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Incrementable {
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    // 创建私有类的一个引用
    Incrementable getCallbackReference() {
        return new Closure();
    }

}

class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable cbh) {
        callbackReference = cbh;
    }

    void go() {
        callbackReference.increment();
    }

}
