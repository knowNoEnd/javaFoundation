package main.java.testjavafound.arrays;

import org.junit.Test;

import java.util.Arrays;

public class TestArrrays {

    @Test
    public void aa(){
        RaggedArray[] dd = new RaggedArray[10];
        System.out.println(Arrays.toString(dd));
        System.out.println(Arrays.deepToString(dd));
    }
}
