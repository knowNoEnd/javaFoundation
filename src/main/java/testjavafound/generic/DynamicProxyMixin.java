package main.java.testjavafound.generic;//: generics/DynamicProxyMixin.java

import main.java.testjavafound.net.mindview.util.TwoTuple;
import sun.misc.Launcher;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static main.java.testjavafound.net.mindview.util.Tuple.tuple;

class MixinProxy implements InvocationHandler {
  Map<String,Object> delegatesByMethod;
  public MixinProxy(TwoTuple<Object,Class<?>>... pairs) {
    delegatesByMethod = new HashMap<String,Object>();
    for(TwoTuple<Object,Class<?>> pair : pairs) {
      for(Method method : pair.second.getMethods()) {
        String methodName = method.getName();
        // The first interface in the map
        // implements the method.
        if (!delegatesByMethod.containsKey(methodName))
          delegatesByMethod.put(methodName, pair.first);
      }
    }
  }	
  public Object invoke(Object proxy, Method method,
    Object[] args) throws Throwable {
    String methodName = method.getName();
    Object delegate = delegatesByMethod.get(methodName);
    return method.invoke(delegate, args);
  }
  @SuppressWarnings("unchecked")
  public static Object newInstance(TwoTuple... pairs) {
    Class[] interfaces = new Class[pairs.length];
    for(int i = 0; i < pairs.length; i++) {
      interfaces[i] = (Class)pairs[i].second;
    }
    /**
     * java默认有三种类加载器，BootstrapClassLoader、ExtensionClassLoader、App ClassLoader三种。
     *  BootstrapClassLoader是嵌在JVM内核中的加载器，该加载器是用C++语言写的，主要负载加载JAVA_HOME/lib下的类库，启动类加载器无法被应用程序直接使用。ExtensionClassLoader是用JAVA编写，且它的父类加载器是Bootstrap，是由sun.misc.Launcher$ExtClassLoader实现的，主要加载JAVA_HOME/lib/ext目录中的类库。
     *  ExtensionClassLoader是用JAVA编写，且它的父类加载器是Bootstrap，是由sun.misc.Launcher$ExtClassLoader实现的，主要加载JAVA_HOME/lib/ext目录中的类库。我们知道java中系统属性java.ext.dirs指定的目录由ExtClassLoader加载器加载，如果程序中没有指定该系统属性（-Djava.ext.dirs=sss/lib）那么该加载器默认加载$JAVA_HOME/lib/ext目录下的所有jar文件，通过程序来看下系统变量java.ext.dirs所指定的路径
     *  App ClassLoader是应用程序类加载器，负责加载应用程序classpath目录下的所有jar和class文件。
     *  它的父加载器为Ext ClassLoader
     */
    ClassLoader cl =
      pairs[0].first.getClass().getClassLoader();
    return Proxy.newProxyInstance(
      cl, interfaces, new MixinProxy(pairs));
  }
}

public class DynamicProxyMixin {
  public static void main(String[] args) {
    Object mixin = MixinProxy.newInstance(
      tuple(new BasicImp(), Basic.class),
      tuple(new TimeStampedImp(), TimeStamped.class),
      tuple(new SerialNumberedImp(),SerialNumbered.class));
    Basic b = (Basic)mixin;
    TimeStamped t = (TimeStamped)mixin;
    SerialNumbered s = (SerialNumbered)mixin;
    b.set("Hello");
    System.out.println(b.get());
    System.out.println(t.getStamp());
    System.out.println(s.getSerialNumber());
  }
}
