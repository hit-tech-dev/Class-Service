package com.hit.classservice.application.input_boundary.notification;

import com.hit.classservice.application.input.notification.DeleteNotificationInput;
import com.hit.classservice.application.input.notification.GetNotificationInput;
import com.hit.classservice.application.input_boundary.UseCase;
import com.hit.classservice.application.output.notification.DeleteNotificationOutput;
import com.hit.classservice.application.output.notification.GetNotificationOutput;

public interface GetNotificationDataCase extends UseCase<GetNotificationInput, GetNotificationOutput> {
}
