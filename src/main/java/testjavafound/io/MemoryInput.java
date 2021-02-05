package main.java.testjavafound.io;//: io/MemoryInput.java

import java.io.IOException;
import java.io.StringReader;

// 从内存输入
public class MemoryInput {
  public static void main(String[] args)
  throws IOException {
    StringReader in = new StringReader(
      BufferedInputFile.read("src/main/java/testjavafound/io/MemoryInput.java"));
    int c;
    while((c = in.read()) != -1)
      System.out.print((char)c);
  }
}
