package main.java.testjavafound.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileLocking2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos= new FileOutputStream("file.txt");
        try {
            fos.write("bbbbbbbbbjjjjjjjkkkkkkdsssss".getBytes());
        } catch (IOException e) {
            fos.close();
            e.printStackTrace();
        }

    }
}
