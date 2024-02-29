package Notification.example.Notification.service.Imp;

import Notification.example.Notification.dto.Notificationsdto;
import Notification.example.Notification.entity.Notifications;
import Notification.example.Notification.repository.NotificationsRepository;
import Notification.example.Notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImp implements NotificationService {

    @Autowired
    private NotificationsRepository notificationsRepository;
    @Override
    public List<Notifications> getAllNotifications() {
        return notificationsRepository.findByReadStatusFalseOrReadStatusNull();
    }

    @Override
    public boolean updateNotifications(List<Notifications> notificationsList) {
        for (Notifications notification : notificationsList) {
            // Retrieve the existing notification from the database (if it exists)
            Optional<Notifications> existingNotificationOptional = notificationsRepository.findByCategory(notification.getCategory());

            // Check if the notification exists in the database
            if (existingNotificationOptional.isPresent()) {
                // Update the existing notification with the new data
                Notifications existingNotification = existingNotificationOptional.get();
                existingNotification.setHeader(notification.getHeader());
                existingNotification.setBody(notification.getBody());
                existingNotification.setReadStatus(notification.isReadStatus());
                existingNotification.setCategory(notification.getCategory());

                // Save the updated notification
                Notifications updatedNotification = notificationsRepository.save(existingNotification);
            }
        }
        return true;
    }

    @Override
    public String savecreatePost(List<Notificationsdto> notificationsdtos) {
        List<Notifications> notifications = new ArrayList<>();
        for(Notificationsdto iterationNotificansdto : notificationsdtos){
            Notifications notificationsave = new Notifications();
            notificationsave.setBody(iterationNotificansdto.getBody());
            notificationsave.setCategory(iterationNotificansdto.getCategory());
            notificationsave.setHeader(iterationNotificansdto.getHeader());
            notificationsave.setReadStatus(false);
            notifications.add(notificationsave);
        }
        notificationsRepository.saveAll(notifications);
        return "Created Post";
    }

}