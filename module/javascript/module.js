/* global forge */
forge['accelerometer'] = {
	onChange: {
		addListener: function (callback) {
			forge.internal.addEventListener('accelerometer.onChange', callback);
		}
	},
	setWatchInterval: function (interval, success, error) {
		forge.internal.call("accelerometer.setWatchInterval", {interval: interval}, success, error);
	},
	clearWatchInterval: function (success, error) {
		forge.internal.call("accelerometer.clearWatchInterval", {}, success, error);
	}
};