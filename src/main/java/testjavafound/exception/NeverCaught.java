package main.java.testjavafound.exception;

public class NeverCaught {
    static void f() {
        throw new RuntimeException("From f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        // 结束时自动调用getStackTrace()打印错误
        g();
    }

}
