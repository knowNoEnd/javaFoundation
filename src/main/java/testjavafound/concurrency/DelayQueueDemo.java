package main.java.testjavafound.concurrency;//: concurrency/DelayQueueDemo.java

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static main.java.testjavafound.net.mindview.util.Print.print;
import static main.java.testjavafound.net.mindview.util.Print.printnb;

class DelayedTask implements Runnable, Delayed {
  private static int counter = 0;
  /** final:
   *   如果引用为基本数据类型，则该引用为常量，该值无法修改；
   *   如果引用为引用数据类型，比如对象、数组，则该对象、数组本身可以修改，
   * 但指向该对象或数组的地址的引用不能修改。
   *   如果引用时类的成员变量，则必须当场赋值，否则编译会报错。
   */
  private final int id = counter++;
  private final int delta;
  private final long trigger;
  protected static List<DelayedTask> sequence =
    new ArrayList<DelayedTask>();
  public DelayedTask(int delayInMilliseconds) {
    delta = delayInMilliseconds;
    trigger = System.nanoTime() +
      // NANOSECONDS.convert：转换单位
      NANOSECONDS.convert(delta, MILLISECONDS);
    sequence.add(this);
  }
  public long getDelay(TimeUnit unit) {
    return unit.convert(
      trigger - System.nanoTime(), NANOSECONDS);
  }
  public int compareTo(Delayed arg) {
    DelayedTask that = (DelayedTask)arg;
    if(trigger < that.trigger) return -1;
    if(trigger > that.trigger) return 1;
    return 0;
  }
  public void run() { printnb(this + " "); }
  public String toString() {
    return String.format("[%1$-4d]", delta) +
      " Task " + id;
  }
  public String summary() {
    return "(" + id + ":" + delta + ")";
  }
  public static class EndSentinel extends DelayedTask {
    private ExecutorService exec;
    public EndSentinel(int delay, ExecutorService e) {
      super(delay);
      exec = e;
    }
    public void run() {
      for(DelayedTask pt : sequence) {
        printnb(pt.summary() + " ");
      }
      print();
      print(this + " Calling shutdownNow()");
      exec.shutdownNow();
    }
  }
}

class DelayedTaskConsumer implements Runnable {
  private DelayQueue<DelayedTask> q;
  public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
    this.q = q;
  }
  public void run() {
    try {
      while(!Thread.interrupted())
        q.take().run(); // Run task with the current thread
    } catch(InterruptedException e) {
      // Acceptable way to exit
    }
    print("Finished DelayedTaskConsumer");
  }
}

public class DelayQueueDemo {
  public static void main(String[] args) {
    Random rand = new Random(47);
    ExecutorService exec = Executors.newCachedThreadPool();
    /** DelayQueue
     *    add()
     *    将指定的元素插入到此队列中（如果立即可行且不会违反容量限制），在成功时返回 true，
     *    如果当前没有可用空间，则抛出 IllegalStateException。
     *    offer()
     *    将指定元素插入到此队列的尾部（如果立即可行且不会超出此队列的容量），
     *    在成功时返回 true，如果此队列已满，则返回 false。当使用有容量限制的队列时，
     *    此方法通常要优于 add 方法，后者可能无法插入元素，而只是抛出一个异常。
     *    put()
     *    将指定元素插入到此队列的尾部，如有必要，则等待空间变得可用。
     */
    DelayQueue<DelayedTask> queue =
      new DelayQueue<DelayedTask>();
    // Fill with tasks that have random delays:
    for(int i = 0; i < 20; i++)
      queue.put(new DelayedTask(rand.nextInt(5000)));
    // Set the stopping point
    queue.add(new DelayedTask.EndSentinel(5000, exec));
    exec.execute(new DelayedTaskConsumer(queue));
  }
}
