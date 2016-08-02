package cn.demonk.unittest.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * Created by ligs on 8/2/16.
 */
@RunWith(PowerMockRunner.class)
public class ATest {

    @Test
    @PrepareForTest({A.class,B.class})
    public void testA() throws Exception {
        B sb = PowerMockito.mock(B.class);
        PowerMockito.whenNew(B.class).withNoArguments().thenReturn(sb);
//        A a = PowerMockito.spy(new A());
//        B b = a.getB();
//        a.a();

        A a = new A();
        a.a();

//        PowerMockito.verifyNew(B.class);

        Mockito.verify(sb, Mockito.times(1)).b();

    }
}