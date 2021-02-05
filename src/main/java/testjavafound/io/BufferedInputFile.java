package main.java.testjavafound.io;//: io/BufferedInputFile.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 缓冲输入文件
public class BufferedInputFile {
  // Throw exceptions to console:
  public static String
  read(String filename) throws IOException {
    // Reading input by lines:
    BufferedReader in = new BufferedReader(
      new FileReader(filename));
    String s;
    StringBuilder sb = new StringBuilder();
    StringBuilder str = new StringBuilder();
    // readLine自动将换行符删除了
    while((s = in.readLine())!= null)
      sb.append(s + "\n");

//    int dd ;
//    while ((dd = in.read()) > 0) {
//      char dd1 = (char) dd;
//      str.append(dd1);
//    }

    in.close();
    return sb.toString();
  }
  public static void main(String[] args)
  throws IOException {
    System.out.print(read("src/main/java/testjavafound/io/BufferedInputFile.java"));
  }
}
