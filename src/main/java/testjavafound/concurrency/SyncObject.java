package main.java.testjavafound.concurrency;//: concurrency/SyncObject.java
// Synchronizing on another object.
import static main.java.testjavafound.net.mindview.util.Print.print;

class DualSynch {
  private Object syncObject = new Object();
  public synchronized void f() {
    for(int i = 0; i < 5; i++) {
      print("f()");
      Thread.yield();
    }
  }
  public synchronized void g() {
    for(int i = 0; i < 5; i++) {
      print("g()");
      Thread.yield();
    }
  }
//  public void g() {
//    synchronized(syncObject) {
//      for(int i = 0; i < 5; i++) {
//        print("g()");
//        Thread.yield();
//      }
//    }
//  }
}

public class SyncObject {
  public static void main(String[] args) {
    final DualSynch ds = new DualSynch();
    new Thread() {
      public void run() {
        //
//        try {
//          sleep(2);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
        ds.f();
      }
    }.start();
    // 自定义 判断锁住对象还是锁住方法
//    new Thread() {
//
//      public void run() {
//        try {
//          sleep(1);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//        ds.g();
//      }
//    }.start();
    ds.g();
  }
}
