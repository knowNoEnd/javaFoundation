package main.java.testjavafound.polymorphic;

public class TestPolymorphic {

    public static void tune(Instrument instrument){
        instrument.play(Note.MIDDLE_C);
    }

    public static void main(String[] args){
//        Wind wind = new Wind();
//        tune(wind);
        // 多态
//        Instrument i = new Wind();
//        tune(i);
        // 基类
        Instrument i1 = new Instrument();
        tune(i1);
    }

}

enum Note{
    MIDDLE_C,C_SHARP,B_FLAT;
}

//class Instrument{
//    public void play(Note note){
//        System.out.println("Instrument.play()");
//    }
//}
//
//class Wind extends Instrument{
//    public void play(Node node){
//        System.out.println("Wind.play() " + node);
//    }
//}
