package io.trigger.forge.android.modules.accelerometer;

import io.trigger.forge.android.core.ForgeParam;
import io.trigger.forge.android.core.ForgeTask;
import android.hardware.SensorManager;
import android.os.Build;

public class API {
	public static void setWatchInterval(final ForgeTask task, @ForgeParam("interval") final double interval) {
		SensorListener sl = SensorListener.getInstance();
		if (sl.mRate != 0) {
			sl.mSensorManager.unregisterListener(sl);
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
			sl.mRate = (int) (interval * 1000000);
		} else {
			sl.mRate = SensorManager.SENSOR_DELAY_NORMAL;
		}
		sl.mSensorManager.registerListener(sl, sl.mAccelerometer, sl.mRate);
		task.success();
	}
	
	public static void clearWatchInterval(final ForgeTask task) {
		SensorListener sl = SensorListener.getInstance();
		if (sl.mRate != 0) {
			sl.mSensorManager.unregisterListener(sl);
		}
		sl.mRate = 0;
		task.success();
	}
	
}
