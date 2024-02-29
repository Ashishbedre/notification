package Notification.example.Notification.service;



import Notification.example.Notification.dto.Notificationsdto;
import Notification.example.Notification.entity.Notifications;

import java.util.List;

public interface NotificationService {

    List<Notifications> getAllNotifications();

    boolean updateNotifications(List<Notifications> notificationsList);

    String savecreatePost(List<Notificationsdto> notificationsdtos);
}
