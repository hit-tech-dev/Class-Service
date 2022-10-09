package com.hit.classservice.application.interator.notification;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.NotificationRepository;
import com.hit.classservice.application.input.notification.ReadNotificationInput;
import com.hit.classservice.application.input_boundary.notification.ReadNotificationDataCase;
import com.hit.classservice.application.output.notification.ReadNotificationOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Notification;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationReadNotificationInteractor")
public class ReadNotificationInteractor implements ReadNotificationDataCase {

    private final NotificationRepository notificationRepository;

    public ReadNotificationInteractor(@Qualifier("DatabaseNotificationRepository") NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @SneakyThrows
    @Override
    public ReadNotificationOutput handle(ReadNotificationInput input) throws Exception {
        Notification notification = notificationRepository.findById(input.getId());
        if(ObjectUtils.isEmpty(notification)) {
            throw new VsException(UserMessageConstant.Notification.ERR_NOT_FOUND_BY_ID,
                    String.format(DevMessageConstant.Notification.ERR_NOT_FOUND_BY_ID, input.getId()),
                    new String[]{input.getId().toString()});
        }
        notificationRepository.readNotification(input.getId());
        return new ReadNotificationOutput(CommonConstant.TRUE, "Is Read");
    }
}
