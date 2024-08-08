package Notification.example.Notification.repository;

import Notification.example.Notification.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface NotificationsRepository extends JpaRepository<Notifications,Long> {
    List<Notifications> findByReadStatusFalseOrReadStatusNull();

//    @Query("SELECT n FROM Notifications n WHERE n.category = :category AND n.localdatetime = :localDateTime AND n.id = :id")
    Optional<Notifications> findById(Long id);


}
