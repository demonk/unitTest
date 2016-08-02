package cn.demonk.unittest;

import android.util.Log;

/**
 * Created by ligs on 7/30/16.
 */
public class Dependency {

    public int a = 1;
    public String b;

    public Dependency() {
        a = 2;
        b = "test";
    }

    public boolean right(int a) {
        return a % 2 == 1;
    }

    public boolean classTest(Class a) {
//        return methodA(1,"aa");
        return methodB();
    }

    private boolean methodA(int a, String b) {
        return false;
    }

    private boolean methodB() {
        return false;
    }

    public void run() {
        System.out.println("dependency run: " + b + "::" + a);
    }
}
