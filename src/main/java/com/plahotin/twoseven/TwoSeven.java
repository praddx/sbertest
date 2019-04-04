package com.plahotin.twoseven;

public class TwoSeven {

    public static void main(String[] args) {
        String s = "";
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                s += "Two";
            }
            if (i % 7 == 0) {
                s += "Seven";
            }
            if (s.isEmpty()) {
                System.out.println(i);
            } else {
                System.out.println(s);
                s = "";
            }
        }
    }
}
