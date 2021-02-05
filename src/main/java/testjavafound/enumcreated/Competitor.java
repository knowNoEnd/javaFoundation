//: enumerated/Competitor.java
// Switching one enum on another.
package main.java.testjavafound.enumcreated;

public interface Competitor<T extends Competitor<T>> {
  Outcome compete(T competitor);
} ///:~
