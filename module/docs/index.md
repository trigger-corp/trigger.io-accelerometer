``accelerometer``: Accelerometer access
=======================================

The ``forge.accelerometer`` namespace allows you to access hardware accelerometer data.

## Config options

usage_description
:   This key lets you describe the reason your app accesses the device's accelerometer. When the system prompts the user to allow access, this string is displayed as part of the alert.


##API

!method: forge.accelerometer.setWatchInterval(interval, success, error)
!platforms: iOS, Android
!param: interval `number` the number of seconds between updates (can be a fraction), on Android this is only used as a hint and you are likely to receive updates more frequently.
!param: success `function()` will be invoked when the interval is set successfully
!param: error `function(content)` called with details of any error which may occur
!description: Sets the amount of time between accelerometer updates, this method must be called at least once to start accelerometer updates.

!method: forge.accelerometer.clearWatchInterval(success, error)
!platforms: iOS, Android
!param: success `function()` will be invoked when the interval is cleared
!param: error `function(content)` called with details of any error which may occur
!description: Clears the current watch interval, once this has been called accelerometer updates will stop.

!method: forge.accelerometer.onChange.addListener(callback, error)
!platforms: iOS, Android
!param: callback `function(data)` will be called when updated accelerometer data is available.
!param: error `function(content)` called with details of any error which may occur
!description: Adds a listener for accelerometer data, the format of the data returned is `{"x": 0.2, "y": 0.4, "z": 0.6}` where x, y and z are the acceleration in that axis minus gravity. This means if a device is on a flat surface the returned value will be `{"x": 0, "y": 0, "z": 9.81}`.

##Example

	// Alert the user the first time they put their device on a flat surface
	forge.accelerometer.onChange.addListener(function (data) {
	  if (data.z > 9 && data.z < 11) {
		forge.accelerometer.clearWatchInterval();
		alert("Phone is flat");
	  }
	});
	forge.accelerometer.setWatchInterval(1);