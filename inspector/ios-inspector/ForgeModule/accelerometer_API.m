#import "accelerometer_API.h"
#import "accelerometer_Delegate.h"

static accelerometer_Delegate* delegate;

@implementation accelerometer_API

+ (void)setWatchInterval:(ForgeTask*)task interval:(NSNumber*)interval {
	if ([UIAccelerometer sharedAccelerometer].delegate == nil) {
		if (delegate == nil) {
			delegate = [[accelerometer_Delegate alloc] init];
		}
		[UIAccelerometer sharedAccelerometer].delegate = delegate;
	}
	[UIAccelerometer sharedAccelerometer].updateInterval = [interval floatValue];
	[task success:nil];
}

+ (void)clearWatchInterval:(ForgeTask*)task {
	[UIAccelerometer sharedAccelerometer].delegate = nil;
	[task success:nil];
}

@end
