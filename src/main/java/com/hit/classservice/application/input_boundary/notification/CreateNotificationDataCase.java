package com.hit.classservice.application.input_boundary.notification;

import com.hit.classservice.application.input.notification.CreateNotificationInput;
import com.hit.classservice.application.input.notification.GetNotificationInput;
import com.hit.classservice.application.input_boundary.UseCase;
import com.hit.classservice.application.output.notification.CreateNotificationOutput;
import com.hit.classservice.application.output.notification.GetNotificationOutput;

public interface CreateNotificationDataCase extends UseCase<CreateNotificationInput, CreateNotificationOutput> {
}
