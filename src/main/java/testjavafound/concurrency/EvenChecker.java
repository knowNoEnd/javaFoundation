package main.java.testjavafound.concurrency;//: concurrency/EvenChecker.java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EvenChecker implements Runnable {
  private IntGenerator generator;
  private final int id;
  public EvenChecker(IntGenerator g, int ident) {
    generator = g;
    id = ident;
  }
  public void run() {
    while(!generator.isCanceled()) {
      int val = generator.next();
      if(val % 2 != 0) {
        System.out.println(val + " not even!");
      /**
       * 自定义 延长时间，让 10 个线程全跑完
       *   try {
       *         TimeUnit.MILLISECONDS.sleep(1000);
       *       } catch (InterruptedException e) {
       *         e.printStackTrace();
       *       }
       */

        generator.cancel(); // Cancels all EvenCheckers
      }
    }
  }
  // Test any type of IntGenerator:
  public static void test(IntGenerator gp, int count) {
    System.out.println("Press Control-C to exit");
    ExecutorService exec = Executors.newCachedThreadPool();
    for(int i = 0; i < count; i++)
      exec.execute(new EvenChecker(gp, i));
    /**
     * 自定义 延长时间，让 10 个线程全跑完
     *  try {
     *       TimeUnit.MILLISECONDS.sleep(1900);
     *     } catch (InterruptedException e) {
     *       e.printStackTrace();
     *     }
     */

    exec.shutdown();
  }
  // Default value for count:
  public static void test(IntGenerator gp) {
    test(gp, 10);
  }
}
