package com.hit.classservice.application.input_boundary.notification;

import com.hit.classservice.application.input.notification.GetNotificationInput;
import com.hit.classservice.application.input.notification.ReadNotificationInput;
import com.hit.classservice.application.input_boundary.UseCase;
import com.hit.classservice.application.output.notification.GetNotificationOutput;
import com.hit.classservice.application.output.notification.ReadNotificationOutput;

public interface ReadNotificationDataCase extends UseCase<ReadNotificationInput, ReadNotificationOutput> {
}
