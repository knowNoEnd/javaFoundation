package main.java.testjavafound.exception;

public class TestException3 {

    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("栈中长度 " + e.getStackTrace().length);
            // e.getStackTrace()获取栈中值
            for (StackTraceElement ste : e.getStackTrace()) {
//                System.out.println(ste.getMethodName());
                System.out.println(ste.toString());
            }
        }
    }

    static void g() {
        f();
    }
    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("-------------------------");
        g();
        System.out.println("---------------");
        h();
    }

}
