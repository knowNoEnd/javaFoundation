package main.java.testjavafound.strings;//: strings/IntegerMatch.java

public class IntegerMatch {
  public static void main(String[] args) {
    System.out.println("-1234".matches("-?\\d+"));
    System.out.println("5678".matches("-?\\d+"));
    System.out.println("+911".matches("-?\\d+"));
    System.out.println("+911".matches("(-|\\+)?\\d+"));
    /**
     * -?:是否前面有-号，可以有，可以没有，但不可以是+
     * \\:java正则表达式语法代表符号之后是正则表达式
     * d+:d表示是整数，+表示有一个或多个整数
     * |:或
     * +:+在正则表达式中表示一次或者多次
     * \\+:表示字面意思+号
     */
  }

}
