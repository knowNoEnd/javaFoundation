package main.java.testjavafound.exception;

import main.java.testjavafound.down.JavaDown;

import javax.print.Doc;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.SortedMap;
import java.util.logging.Logger;

public class TestEception2 {

    /**
     *     public final static JavaDown java22 = null;
     *
     *     public static JavaDown getJava22() {
     *         return java22;
     *     }
     *
     *     public static void setJava22(JavaDown printWriter) {
     *         String ss = null;
     *     }
     */

    private static Logger logger =
        Logger.getLogger("LoggingExceptions2");

    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        // server输出日志级别是严重
        logger.severe(trace.toString());
        System.out.println(trace.toString());
    }

    public static void main(String[] args) {
//        java22.notify();
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
        }
    }

}

