package cn.demonk.unittest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * Created by ligs on 7/31/16.
 */
@RunWith(PowerMockRunner.class)
public class TargetTest2 {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    @PrepareForTest(Dependency.class)
    public void testRun() throws Exception {
        Dependency dependency = PowerMockito.spy(new Dependency());
        PowerMockito.doReturn(true).when(dependency, "methodA", Mockito.anyInt(), Mockito.any(String.class));

        assertTrue(dependency.classTest(Mockito.any(Class.class)));
        PowerMockito.verifyPrivate(dependency, Mockito.times(1)).invoke("methodA", Mockito.anyInt(),Mockito.any(String.class));


    }
}