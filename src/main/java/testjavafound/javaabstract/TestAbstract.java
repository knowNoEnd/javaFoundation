package main.java.testjavafound.javaabstract;

public class TestAbstract extends Cc {
    @Override
    public void dd() {}

    @Override
    public int hh() {
        return 0;
    }

    @Override
    public void cc() {super.cc();}
}

abstract class Cc{
    public abstract void dd();
    public abstract int hh();
    int ss = 22;

    public void cc() {
        int cc;
        System.out.println("dd bb cc ,,,");
    }

    public static void main(String[] args) {
        new Cc() {
            @Override
            public void dd() {

            }

            @Override
            public int hh() {
                return 0;
            }
        };
    }
}

class ccdd{
    public static void main(String[] args) {
        TestAbstract testAbstract = new TestAbstract();
        System.out.println(testAbstract);
    }
}

interface cb{
    void abb();
}

class hhbb implements cb{
    @Override
    public void abb() {

    }
}
