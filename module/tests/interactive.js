/* global module, asyncTest, askQuestion, forge, ok, start */

module("forge.accelerometer");

asyncTest("accelerometer orientation", 1, function() {
	askQuestion("Hold the phone upright, press 'OK' then place the phone flat on a surface", {
		OK: function () {
			var done = false;
			forge.accelerometer.onChange.addListener(function (data) {
				if (data.z < 11 && data.z > 9 && data.x < 1 && data.x > -1 && data.y < 1 && data.y > -1 && !done) {
					done = true;
					ok(true);
					start();
					forge.accelerometer.clearWatchInterval();
				}
			});
			forge.accelerometer.setWatchInterval(1, function () {
			}, function () {
				ok(false, "Error starting accelerometer");
				start();
			});
		},
		"Skip test": function () {
			ok(true, "Test skipped");
			start();
		}
	});
});


asyncTest("accelerometer shake", 1, function() {
	askQuestion("Press 'OK' then shake the device", {
		OK: function () {
			var done = false;
			forge.accelerometer.onChange.addListener(function (data) {
				if (!done && (Math.abs(data.x) + Math.abs(data.y) + Math.abs(data.z)) > 50) {
					done = true;
					ok(true);
					start();
					forge.accelerometer.clearWatchInterval();
				}
			});
			forge.accelerometer.setWatchInterval(1, function () {
			}, function () {
				ok(false, "Error starting accelerometer");
				start();
			});
		},
		"Skip test": function () {
			ok(true, "Test skipped");
			start();
		}
	});
});