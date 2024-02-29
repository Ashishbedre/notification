package Notification.example.Notification.repository;

import Notification.example.Notification.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface NotificationsRepository extends JpaRepository<Notifications,Long> {
    List<Notifications> findByReadStatusFalseOrReadStatusNull();

    Optional<Notifications> findByCategoryAndLocaldatetime(String category, LocalDateTime localDateTime);


}
