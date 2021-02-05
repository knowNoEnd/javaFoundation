package main.java.testjavafound.strings;//: strings/Splitting.java

import java.util.Arrays;

public class Splitting {
  public static String knights =
    "Then, when you have found the shrubbery, you must " +
    "cut down the mightiest tree in the forest... " +
    "with... a herring!";
  public static void split(String regex) {
    System.out.println(
      Arrays.toString(knights.split(regex)));
  }
  public static void main(String[] args) {
    // 按空格分割
    split(" "); // Doesn't have to contain regex chars
    // \W：非单词字符 \w：一个单词字符
    split("\\W"); // Non-word characters
    split("n\\W+"); // 'n' followed by non-word characters
  }

}
