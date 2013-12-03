package io.trigger.forge.android.modules.accelerometer;

import io.trigger.forge.android.core.ForgeEventListener;

public class EventListener extends ForgeEventListener {
	@Override
	public void onStop() {
		SensorListener sl = SensorListener.getInstance();
		if (sl.mRate != 0) {
			sl.mSensorManager.unregisterListener(sl);
		}
	}

	@Override
	public void onRestart() {
		SensorListener sl = SensorListener.getInstance();
		if (sl.mRate != 0) {
			sl.mSensorManager.registerListener(sl, sl.mAccelerometer, sl.mRate);
		}
	}
}
