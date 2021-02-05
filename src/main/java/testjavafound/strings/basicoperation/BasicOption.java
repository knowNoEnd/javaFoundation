package main.java.testjavafound.strings.basicoperation;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import main.java.testjavafound.io.TestFile01;
import org.junit.Test;
import sun.util.resources.da.CalendarData_da;

import java.util.Arrays;

public class BasicOption extends TestFile01 {

    // 构造器
    @Test
    public void TestBasicController() {
        // string
        String cc = new String("String");
        System.out.println(cc);
        // stringBuilder
        StringBuilder stringBuilder = new StringBuilder("StringBuilder");
        String s = new String(stringBuilder);
        System.out.println(s);
        // stringBuffer
        StringBuffer stringBuffer = new StringBuffer("StringBuffer");
        String s1 = new String(stringBuffer);
        System.out.println(s1);
        // char[]
//        String[] strings = {"dd","gg","c"};
        char[] chars = {'d','c','|','9'};
        String s2 = new String(chars);
        System.out.println(s2);
        // byte
        byte[] bytes = {'c',',','|'};
        String s3 = new String(bytes);
        System.out.println(s3);
    }

    // 长度
    @Test
    public void TestBasicLength() {
        String cc = "ddddd";
        System.out.println(cc.length());
    }

    // charAt
    @Test
    public void TestBasicCharAt() {
        String cc = "dduuyiuuloil;1!rtyi90877543梦76|><dd";
        char c = cc.charAt(27);
        System.out.println(c);
    }

    // getCharts,getBytes
    @Test
    public void TestBasicGetCharts() {
        String cc = "dduuyiuuloil;1!rtyi90877543梦76|><dd";
        // char[]数组不能先定义再赋值
        char chars[] = new char[50];
        chars[0] = '3';
        cc.getChars(2,20,chars,6);
        System.out.println(chars);
    }

    // toCharArray
    @Test
    public void TestBasicToCharArray() {
        String cc = "dduuyiuuloil;1!rtyi90877543梦76|><dd";
        // char[]数组不能先定义再赋值
        char[] chars = cc.toCharArray();
        // sort 分类;排序
        Arrays.sort(chars);
        for (char c : chars) {
            System.out.print(c);
        }
    }

    // equals,equalsIgnoreCase
    @Test
    public void TestBasicEquals() {
        // equals
        String cc = "dduuyiuuloil";
        boolean uu = cc.equals("dduuyiuuloil");
        System.out.println(uu);
        // equalsIgnoreCase Case实例; 具体情况
        boolean b = cc.equalsIgnoreCase("dduuyiuuloiL");
        System.out.println(b);
    }

    // compareTo 比较第一个不同字母的asc码值
    @Test
    public void TestBasicCompareTo() {
        String cc = "dduuyiuuloil";
        int i = cc.compareTo("aduuyiuuloil");
        System.out.println(i);
    }

    // contains 第一次存在
    @Test
    public void TestBasicContains() {
        String cc = "dduuyiuuloil";
        boolean cc1 = cc.contains("uu");
        System.out.println(cc1);
    }

    // contentEquals content内容
    @Test
    public void TestBasicContentEquals() {
        String cc = "dduuyiuuloil";
        boolean ccc = cc.contentEquals("dduuyiuuloil");
        System.out.println(ccc);
    }

    // equalsIgnoreCase
    @Test
    public void TestBasicEqualsIgnoreCase() {
        String cc = "dduuyiuuloil";
        boolean dd = cc.equalsIgnoreCase("DDuuyiuuloil");
        System.out.println(dd);
    }

    // regionMatcher region区域，地方
    @Test
    public void TestBasicEqualsRegionMatcher() {
        String cc = "dduuyiuuloil";
        boolean cc1 = cc.regionMatches(2,"uuygs88893f-0egj",0,2);
        System.out.println(cc1);
    }

    // startsWith
    @Test
    public void TestBasicStartsWith() {
        String cc = "dduuyiuuloil";
        boolean dd = cc.startsWith("dd");
        System.out.println(dd);
        boolean uu = cc.startsWith("uu", 2);// toffset开始比较位置
        System.out.println(uu);
    }

    // endsWith
    @Test
    public void TestBasicEndsWith() {
        String cc = "dduuyiuuloil";
        boolean l = cc.endsWith("l");
        System.out.println(l);
    }

    // indexOf，lastIndexOf
    @Test
    public void TestBasicIndexOf() {
        String cc = "dduuyiuuloil";
        int i = cc.indexOf("uuy");
        System.out.println(i);
        int i1 = cc.indexOf(3,5);
        System.out.println(i1);
        int i2 = cc.lastIndexOf("l");
        System.out.println(i2);
    }

    // subString
    @Test
    public void TestBasicSubString() {
        String cc = "dduuyiuuloil";
        String substring = cc.substring(3, 9);
        System.out.println(substring);
    }

    // concat
    @Test
    public void TestBasicConcat() {
        String cc = "dduuyiuuloil";
        String cocci = cc.concat("coccccccc");
        System.out.println(cocci);
    }

    // replaces
    @Test
    public void TestBasicReplaces() {
        String cc = "dduuyiuuloil";
        String replace = cc.replace("uu", "yyyyyyyyyyyy");
        System.out.println(replace);
    }

    // toLowerCase,toUpperCase
    @Test
    public void TestBasicToLowerCase() {
        String cc = "dduuyiuuloil";
        String s = cc.toLowerCase();
        System.out.println(s);
        String s1 = cc.toUpperCase();
        System.out.println(s1);
    }

    // trim
    @Test
    public void TestBasicTrim() {
        String cc = "    dduuyiuuloil    ";
        // 删除两端空白符
        String trim = cc.trim();
        System.out.println(cc);
        System.out.println(trim);
    }

    // valueOf
    @Test
    public void TestBasicValueOf() {
        String cc = "dduuyiuuloil";
        String s = cc.valueOf(33335);
        String s1 = String.valueOf(33335);
        System.out.println(s);
        System.out.println(s1);
    }

    // intern
    @Test
    public void TestBasicIntern() {
        String cc = "dduuyiuuloil";
        String intern = cc.intern();
        System.out.println(intern);
        System.out.println(cc.getClass().toString());
        System.out.println(intern.getClass().toString());
    }

    // format
    @Test
    public void TestBasicFormat() {
        String cc = "dduuyiuuloil";
        // %5.2 5是宽度，2是截取的长度
        String format = String.format("%5.2s %3.2s  %2.2s", cc, cc, cc);
        System.out.println(format);
    }

}



