package Notification.example.Notification.controller;


import Notification.example.Notification.dto.Notificationsdto;
import Notification.example.Notification.entity.Notifications;
import Notification.example.Notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/V1/DashBoard")
@CrossOrigin
public class DashBoard {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notifications")
    public ResponseEntity<List<Notifications>> notifications(){
        return  new ResponseEntity<>(notificationService.getAllNotifications(), HttpStatus.OK);
    }

    @PutMapping("/updateNotifications")
    public ResponseEntity<Boolean> updateNotifications(@RequestBody List<Notifications> updateNotifications){
        return  new ResponseEntity<>(notificationService.updateNotifications(updateNotifications),HttpStatus.OK);
    }

    @PostMapping("/createPost")
    public ResponseEntity<String> createPost(@RequestBody List<Notificationsdto> updateNotifications){
        return  new ResponseEntity<>(notificationService.saveCreatePost(updateNotifications),HttpStatus.OK);
    }

}
