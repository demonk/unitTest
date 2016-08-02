package cn.demonk.unittest;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;
import static org.junit.Assert.*;

/**
 * Created by ligs on 8/2/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

    @Test
    @Config(application = CustomApplication.class)
    public void onClickChange() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        activity.findViewById(R.id.button).performClick();
        File a = new File(Environment.getExternalStorageDirectory(), "test");
        FileInputStream in = new FileInputStream(a);
        byte[] buffer = new byte[1024];
        in.read(buffer);
        String b = new String(buffer);
        System.out.println(b);
        System.out.println(TextUtils.equals(b, "test"));

        assertTrue(TextUtils.equals(b,"test"));
//        Intent expectedIntent = new Intent(activity, SecActivity.class);
//        assertEquals(expectedIntent, shadowOf(activity).getNextStartedActivity());
//        assertThat(shadowOf(activity).getNextStartedActivity()).isEqualTo(expectedIntent);
    }

    @Test
    public void testLifeCycle() {
//        Activity activity = Robolectric.buildActivity(SecActivity.class).create().get();
        ActivityController controller = Robolectric.buildActivity(SecActivity.class).withIntent(null).create().start();
//        ActivityController controllerSpy = PowerMockito.spy(controller);

        SecActivity activity = (SecActivity) controller.get();
//        SecActivity activitySpy = PowerMockito.spy(activity);

        controller.resume();
//        controllerSpy.resume();
    }
}