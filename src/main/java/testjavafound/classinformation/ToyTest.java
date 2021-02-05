package main.java.testjavafound.classinformation;


public class ToyTest {

    static void printInfo(Class cc) {
        System.out.println("Class name:" + cc.getName() +
                " is interface?[" + cc.isInterface() + "]");
        System.out.println("Simple name:" + cc.getSimpleName());
        System.out.println("Canonical name:" + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("main.java.testjavafound.classinformation.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            // 系统终止
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
            printInfo(obj.getClass());
        }

        System.out.println("==================");
        // getSuperclass()返回该类的基类
        Class superclass = c.getSuperclass();
        System.out.println(superclass);

    }
}

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy() {
    }
    Toy(int i) {
    }
}
class FancyToy extends Toy
        implements HasBatteries,Waterproof,Shoots {
    FancyToy() {
        super(1);
    }
}
