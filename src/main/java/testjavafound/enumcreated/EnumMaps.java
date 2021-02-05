//: enumerated/EnumMaps.java
// Basics of EnumMaps.
package main.java.testjavafound.enumcreated;

import java.util.EnumMap;
import java.util.Map;

import static main.java.testjavafound.enumcreated.AlarmPoints.*;
import static main.java.testjavafound.net.mindview.util.Print.print;
import static main.java.testjavafound.net.mindview.util.Print.printnb;

interface Command { void action(); }

public class EnumMaps {
  public static void main(String[] args) {
    EnumMap<AlarmPoints,Command> em =
      new EnumMap<AlarmPoints,Command>(AlarmPoints.class);
    em.put(KITCHEN, new Command() {
      public void action() { print("Kitchen fire!"); }
    });
    em.put(BATHROOM, new Command() {
      public void action() { print("Bathroom alert!"); }
    });
    for(Map.Entry<AlarmPoints,Command> e : em.entrySet()) {
      printnb(e.getKey() + ": ");
      e.getValue().action();
    }
    try { // If there's no value for a particular key:
      em.get(UTILITY).action();
    } catch(Exception e) {
      print(e);
    }
  }
}
