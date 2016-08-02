package cn.demonk.unittest;

/**
 * Created by ligs on 7/30/16.
 */
public class Target {

    public boolean run(Dependency dependency, boolean param) {
        dependency = new Dependency();
        System.out.println("run");
        dependency.run();

        if (dependency.classTest(String.class))
            return dependency.right(3);

        return false;
    }

    public boolean run2() {
        Singleton.instance().set(3);
        return Singleton.instance().get() == 2;
    }
}
