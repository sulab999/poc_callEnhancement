package com.example.callenhancement;

import android.util.Log;

public class deadcode_test {
    public static int c = 1;
    public static int d = 0;
    public static void test1(){
        int a = 1;
        Log.i("Stat_Info", "a: "+a);
    }
    private void test2(){
        int b = d-1;
        Log.i("Stat_Info", "d: "+b);
    }
}
