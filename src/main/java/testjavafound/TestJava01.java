package main.java.testjavafound;

import org.junit.Test;
import sun.text.resources.FormatData;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestJava01 {
    public static final int PPP = 0;
    static final int DDBB_CCDD = 999999;
    final String CC_CC = "JJJJJBBBBB";

    @Test
    public void cc(){
        System.out.println(CC_CC);
        System.out.println(DDBB_CCDD);
        System.out.println(PPP);
    }

    @Test
    public void dd(){
        //获取当前月第一天：
        SimpleDateFormat format = new SimpleDateFormat();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH,1);//设置为 1 号,当前日期既为本月第一天
        c.add(Calendar.MONTH, 0);
        String first = format.format(c.getTime());
        System.out.println("===============first:"+first);

        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
        System.out.println("===============last:"+last);
    }

}
