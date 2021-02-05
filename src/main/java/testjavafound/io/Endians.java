package main.java.testjavafound.io;//: io/Endians.java
// Endian differences and data storage.

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.util.Arrays;

import static main.java.testjavafound.net.mindview.util.Print.print;

public class Endians {
  public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
    /**
     * Unicode编码：一个英文等于两个字节，
     * 一个中文（含繁体）等于两个字节。
     * 中文标点占两个字节，英文标点占两个字节
     * 1个字节是8位
     */
    // 以charbuffer数据类型放置到bytebuffer
    bb.asCharBuffer().put("abcdef");
    print(Arrays.toString(bb.array()));
    bb.rewind();
    bb.order(ByteOrder.BIG_ENDIAN);
    bb.asCharBuffer().put("abcdef");
    print(Arrays.toString(bb.array()));
    bb.rewind();
    bb.order(ByteOrder.LITTLE_ENDIAN);
    bb.asCharBuffer().put("abcdef");
    print(Arrays.toString(bb.array()));
  }
}
