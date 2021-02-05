package main.java.testjavafound.Internal;

import java.util.Collections;

public class TestInternal {

    public Contents contents() {
        return new Contents() {
            private int i = 0;

            public int value() {
                return i;
            }

            @Override
            public void ddc() {
                super.ddc();
            }
        };
    }

    public Contents destination(String dest) {
        return new Contents() {
            private String label = dest;

            public String readLabeL() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        TestInternal testInternal = new TestInternal();
        System.out.println(testInternal.contents());
    }

}
