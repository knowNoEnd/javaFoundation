package main.java.testjavafound.strings;//: strings/Finding.java

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static main.java.testjavafound.net.mindview.util.Print.print;
import static main.java.testjavafound.net.mindview.util.Print.printnb;

public class Finding {
  public static void main(String[] args) {
//    Matcher m = Pattern.compile("\\w+")
//      .matcher("Evening is full of the linnet's wings");
    /**
     * [ is]:空格和单词在一起，\w+则把空格和单词当作整体进行分割，所以进行了三次分割
     */
    Matcher m = Pattern.compile("\\w+")
            .matcher(" is");
    while(m.find())
      printnb(m.group() + " ");
    print();
    int i = 0;
    while(m.find(i)) {
      printnb(m.group() + " ");
      i++;
    }
  }
}
