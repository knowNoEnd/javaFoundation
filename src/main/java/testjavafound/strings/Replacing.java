package main.java.testjavafound.strings;//: strings/Replacing.java

import static main.java.testjavafound.net.mindview.util.Print.print;

public class Replacing {
  public static String knights =
          "Then, when you have found the shrubbery, you must " +
                  "cut down the mightiest tree in the forest... " +
                  "with... a herring!";
  public static void main(String[] args) {
    print(knights.replaceFirst("f\\w+", "located"));
    print(knights.replaceAll("shrubbery|tree|herring","banana"));
  }

}
