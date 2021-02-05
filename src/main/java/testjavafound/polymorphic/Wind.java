package main.java.testjavafound.polymorphic;

public class Wind extends Instrument {

    public void play(Note note){
        System.out.println("Wind.play() " + note);
    }
}

class Instrument{
    public void play(Note note){
        System.out.println("Instrument.play()");
    }
}
