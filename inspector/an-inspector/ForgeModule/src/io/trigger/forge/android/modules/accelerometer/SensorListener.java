package io.trigger.forge.android.modules.accelerometer;

import io.trigger.forge.android.core.ForgeApp;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.google.gson.JsonObject;

public class SensorListener implements SensorEventListener {
	private static SensorListener instance = null;

	public final SensorManager mSensorManager = (SensorManager) ForgeApp.getActivity().getSystemService(Activity.SENSOR_SERVICE);
	public final Sensor mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	public int mRate = 0;

	protected SensorListener() {

	}

	public static SensorListener getInstance() {
		if (instance == null) {
			instance = new SensorListener();
		}
		return instance;
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		JsonObject result = new JsonObject();
		result.addProperty("x", event.values[0]);
		result.addProperty("y", event.values[1]);
		result.addProperty("z", event.values[2]);
		ForgeApp.event("accelerometer.onChange", result);
	}

}
