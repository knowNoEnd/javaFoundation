package main.java.testjavafound.arrays;//: arrays/PrimitiveConversionDemonstration.java

import main.java.testjavafound.net.mindview.util.ConvertTo;
import main.java.testjavafound.net.mindview.util.CountingGenerator;
import main.java.testjavafound.net.mindview.util.Generated;

import java.util.Arrays;

public class PrimitiveConversionDemonstration {
  public static void main(String[] args) {
    Integer[] a = Generated.array(Integer.class,
        new CountingGenerator.Integer(), 15);
    int[] b = ConvertTo.primitive(a);
    System.out.println(Arrays.toString(b));

    boolean[] c = ConvertTo.primitive(
      Generated.array(Boolean.class,
        new CountingGenerator.Boolean(), 7));
    System.out.println(Arrays.toString(c));
  }
}
