package main.java.testjavafound.io;//: io/FileLocking.java

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
  public static void main(String[] args) throws Exception {
    FileOutputStream fos= new FileOutputStream("file.txt");
    FileLock fl = fos.getChannel().tryLock();
//    FileLock fl = fos.getChannel().lock();
    if(fl != null) {
      System.out.println("Locked File");
      TimeUnit.MILLISECONDS.sleep(10000);
      fl.release();
      System.out.println("Released Lock");
    }
    fos.close();
  }
}
