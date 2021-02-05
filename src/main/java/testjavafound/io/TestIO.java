package main.java.testjavafound.io;

import java.io.*;
import java.util.logging.Filter;

public class TestIO {
    public static void main(String[] args) {
        Filter filter;
        FilterInputStream filterInputStream;
        FilterOutputStream filterOutputStream;
        DataInputStream dataInputStream = null;
        InputStream inputStream;
        Reader reader;
        InputStreamReader inputStreamReader;
        boolean b = System.out.checkError();
        if (b)
            System.out.println("cccccccccc");
//        try {
//            // println自动清理数据
//            PrintWriter printWriter = new PrintWriter(new FileOutputStream("src\\main\\java\\testjavafound\\io\\TestIO.java"),true);
//            printWriter.println("ffffffffffd");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }
}
