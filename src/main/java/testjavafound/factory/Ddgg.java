package main.java.testjavafound.factory;

public class Ddgg {
    class Aj {
        Aj() {};
        public void cb() {
            System.out.println("bbbccc");
        }
    }

    public Aj abb() {
        return new Aj();
    }

    class Bj {
        Bj() {}
        public void dd() {
            Aj aj = new Aj();
            aj.cb();
        }
    }

    public Bj dddc() {
        return new Bj();
    }

    public void dd() {
        Bj bj = new Bj();
        bj.dd();
    }

    public static void main(String[] args) {
        Ddgg ddgg = new Ddgg();
        ddgg.dd();
    }

}
