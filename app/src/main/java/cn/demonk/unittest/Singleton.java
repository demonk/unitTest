package cn.demonk.unittest;

/**
 * Created by ligs on 7/31/16.
 */
public class Singleton {

    private static class InstanceHolder {
        private static Singleton INSTANCE = new Singleton();
    }

    public static Singleton instance() {
        return InstanceHolder.INSTANCE;
    }

    private int mVal = 1;

    public int get() {
        return mVal;
    }

    public void set(int v) {
        this.mVal = v;
    }
}
