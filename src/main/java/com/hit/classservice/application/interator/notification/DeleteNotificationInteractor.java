package com.hit.classservice.application.interator.notification;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.NotificationRepository;
import com.hit.classservice.application.input.notification.DeleteNotificationInput;
import com.hit.classservice.application.input_boundary.notification.DeleteNotificationDataCase;
import com.hit.classservice.application.output.notification.DeleteNotificationOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Notification;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationDeleteNotificationInteractor")
public class DeleteNotificationInteractor implements DeleteNotificationDataCase {

    private final NotificationRepository notificationRepository;

    public DeleteNotificationInteractor(@Qualifier("DatabaseNotificationRepository") NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @SneakyThrows
    @Override
    public DeleteNotificationOutput handle(DeleteNotificationInput input) {
        Notification notification = notificationRepository.findById(input.getId());
        if(ObjectUtils.isEmpty(notification)) {
            throw  new VsException(UserMessageConstant.Notification.ERR_NOT_FOUND_BY_ID,
                    String.format(DevMessageConstant.Notification.ERR_NOT_FOUND_BY_ID, input.getId()),
                    new String[]{input.getId().toString()});
        }
        notificationRepository.deleteById(input.getId());
        return new DeleteNotificationOutput(CommonConstant.TRUE, "Delete sucessful");
    }
}
