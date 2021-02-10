package main.java.testjavafound.concurrency;//: concurrency/Joining.java
// Understanding join().
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static main.java.testjavafound.net.mindview.util.Print.print;

class Sleeper extends Thread {
  private int duration;
  public Sleeper(String name, int sleepTime) {
    super(name);
    duration = sleepTime;
    start();
  }
  public void run() {
    try {
      sleep(duration);
      // 如果一个线程A想让线程B退出，则A将B的中断位(interrupt flag)置为true，
      // 我们说“线程A向线程B发了中断信号”。如果B愿意的话，可以自愿地中断自己的线程。
    } catch(InterruptedException e) {
      print(getName() + " was interrupted. " +
        "isInterrupted(): " + isInterrupted());
      return;
    }
    print(getName() + " has awakened");
  }
}

class Joiner extends Thread {
  private Sleeper sleeper;
  public Joiner(String name, Sleeper sleeper) {
    super(name);
    this.sleeper = sleeper;
    start();
  }
  public void run() {
   try {
      sleeper.join();
    } catch(InterruptedException e) {
      print("Interrupted");
    }
    print(getName() + " join completed");
  }
}

public class Joining {
  public static void main(String[] args) throws InterruptedException {
    Sleeper
      sleepy = new Sleeper("Sleepy", 1500),
      grumpy = new Sleeper("Grumpy", 1500);
    Joiner
      dopey = new Joiner("Dopey", sleepy),
      doc = new Joiner("Doc", grumpy);
    // 自定义睡眠时间
//    TimeUnit.MILLISECONDS.sleep(10000);
    grumpy.interrupt();
  }
}
