package main.java.testjavafound.classinformation;

public class SweetShop {

    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            // forName方法参数传的是路径地址
            Class.forName("main.java.testjavafound.classinformation.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }

}

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}
class Gum {
    static {
        System.out.println("Loading Gum");
    }
}
class Cookie {
    static{
        System.out.println("Loading Cookie");
    }
}




