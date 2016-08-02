package cn.demonk.unittest.simple;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by ligs on 8/2/16.
 */
public class A {

    private B mB;

    public A() {
    }

    public void a() {
        mB = new B();

        try {
//            Constructor con = B.class.getConstructor();
//            mB = (B) con.newInstance();
            mB.b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public B getB() {
        return mB;
    }
}
