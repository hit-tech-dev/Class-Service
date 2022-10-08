package com.hit.classservice.application.interator.notification;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.NotificationRepository;
import com.hit.classservice.application.input.notification.GetNotificationInput;
import com.hit.classservice.application.input_boundary.notification.GetNotificationDataCase;
import com.hit.classservice.application.mapper.NotificationMapper;
import com.hit.classservice.application.output.notification.GetNotificationOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Notification;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationGetNotificationInteractor")
public class GetNotificationInteractor implements GetNotificationDataCase {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public GetNotificationInteractor(@Qualifier("DatabaseNotificationRepository") NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = Mappers.getMapper(NotificationMapper.class);
    }

    @SneakyThrows
    @Override
    public GetNotificationOutput handle(GetNotificationInput input) {

        Notification notification = notificationRepository.findById(input.getId());
        if(ObjectUtils.isEmpty(notification)) {
            throw new VsException(UserMessageConstant.Notification.ERR_NOT_FOUND_BY_ID,
                    String.format(DevMessageConstant.Notification.ERR_NOT_FOUND_BY_ID, input.getId()),
                    new String[]{input.getId().toString()});
        }
        return notificationMapper.toGetNotificationOutput(notification);
    }
}
