package main.java.testjavafound.classinformation;

import java.util.ArrayList;
import java.util.List;

public class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    /**
     * 　　1、两者创建对象的方式不同，前者是实用类的加载机制，后者则是直接创建一个类：
     * 　　2、newInstance创建类是这个类必须已经加载过且已经连接，new创建类是则不需要这个类加载过
     * 　　3、newInstance:
     * 弱类型(GC是回收对象的限制条件很低，容易被回收)、低效率、只能调用无参构造，
     * new 强类型（GC不会自动回收，只有所有的指向对象的引用被移除是才会被回收，
     * 若对象生命周期已经结束，但引用没有被移除，经常会出现内存溢出）
     */
    public List<T> create(int nElements) {
        List<T> result = new ArrayList<T>();
        try {
            for (int i = 0; i < nElements; i++)
                result.add(type.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        // CountedInteger.class则CountedInteger已经被加载过了
        FilledList<CountedInteger> f1 =
                new FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(f1.create(15));
    }
}

class CountedInteger {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return Long.toString(id);
    }
}
