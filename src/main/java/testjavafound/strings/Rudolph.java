package main.java.testjavafound.strings;//: strings/Rudolph.java

public class Rudolph {
  public static void main(String[] args) {
    /**
     * [rR]:小r到大R之间
     * [aeiou]:任意aeiou字符中
     * [a-z]:任意a到z字符
     * 大R开始的后面任意多的内容
     */
    for(String pattern : new String[]{ "Rudolph",
      "[rR]udolph", "[rR][aeiou][a-z]ol.*", "R.*" })
      System.out.println("Rudolph".matches(pattern));
  }
} /* Output:
true
true
true
true
*///:~
