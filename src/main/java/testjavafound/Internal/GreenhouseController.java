package main.java.testjavafound.Internal;

public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControllers gc = new GreenhouseControllers();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new waterOn(660),
                gc.new waterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(
                gc.new Restart(2000, eventList));
        if (args.length == 1)
            gc.addEvent(
                    new GreenhouseControllers.Terminate(
                            new Integer(args[0])
                    )
            );
        gc.run();
    }
}
