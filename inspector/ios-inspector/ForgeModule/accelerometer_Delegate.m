//
//  accelerometer_Delegate.m
//  ForgeModule
//
//  Created by Connor Dunn on 31/10/2013.
//  Copyright (c) 2013 Trigger Corp. All rights reserved.
//

#import "accelerometer_Delegate.h"

static double g = 9.78;

@implementation accelerometer_Delegate

- (void)accelerometer:(UIAccelerometer *)accelerometer didAccelerate:(UIAcceleration *)acceleration {
	[[ForgeApp sharedApp] event:@"accelerometer.onChange" withParam:@{
		@"x": [NSNumber numberWithDouble:-acceleration.x*g],
		@"y": [NSNumber numberWithDouble:-acceleration.y*g],
		@"z": [NSNumber numberWithDouble:-acceleration.z*g]
	}];
}

@end
