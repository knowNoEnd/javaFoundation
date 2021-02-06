package main.java.testjavafound.io;//: io/BasicFileOutput.java
import java.io.*;

public class BasicFileOutput {
  static String file = "src/main/java/testjavafound/io/BasicFileOutput.java";
  public static void main(String[] args)
  throws IOException {
    BufferedReader in = new BufferedReader(
      new StringReader(
        BufferedInputFile.read("src/main/java/testjavafound/io/BasicFileOutput.java")));
    PrintWriter out = new PrintWriter(
      new BufferedWriter(new FileWriter(file)));
    int lineCount = 1;
    String s;
    while((s = in.readLine()) != null )
//      out.println(lineCount++ + ": " + s);
      out.println(s + " // 文件输出");
    out.close();

    // Show the stored file:
    System.out.println(BufferedInputFile.read(file));
  }
}
