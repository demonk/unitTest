package cn.demonk.unittest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * Created by ligs on 7/30/16.
 */
@RunWith(PowerMockRunner.class)
public class TargetTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    @PrepareForTest({Dependency.class})
    public void testRun() throws Exception {

        Dependency dependency = PowerMockito.mock(Dependency.class);
        PowerMockito.mockStatic(Dependency.class);

        PowerMockito.doCallRealMethod().when(dependency).run();
        PowerMockito.when(dependency.right(Mockito.anyInt())).thenReturn(true);

        PowerMockito.when(dependency.classTest(Mockito.any(Class.class))).thenReturn(true);

        Dependency d = PowerMockito.mock(Dependency.class);
        PowerMockito.whenNew(Dependency.class).withNoArguments().thenReturn(d);//假如对象内有新的对象创建则返回mock的对象

        Target target = new Target();
        target.run(dependency, false);
        PowerMockito.verifyNew(Dependency.class);

//        assertTrue(target.run(dependency, false));


//        Mockito.verify(dependency, Mockito.times(1)).run();
//
//        Mockito.verify(dependency, Mockito.atLeast(1)).run();
//        Mockito.verify(dependency, Mockito.atMost(2)).run();

        System.out.println(dependency.b);
    }

    @Test
    @PrepareForTest({Singleton.class})
    public void testRun2() throws Exception {
        Singleton singleton = PowerMockito.mock(Singleton.class);
        PowerMockito.mockStatic(Singleton.class);

        PowerMockito.when(Singleton.instance()).thenReturn(singleton);
        PowerMockito.when(singleton.get()).thenReturn(2);

        PowerMockito.doNothing().when(singleton).set(Mockito.anyInt());

        Target target = new Target();
        assertTrue(target.run2());
    }
}