package org.kas.demos.Prac.CoderpatQuest.DAY23_21_10.NotificationSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationService {
        private Map<NotificationType, NotificationSender> senderMap;

        public NotificationService(List<NotificationSender> senders) {
            senderMap = new HashMap<>();
            for (NotificationSender sender : senders) {
                senderMap.put(sender.getSupportedType(), sender);
            }
        }

        public void sendNotification(Notification notification) {
            NotificationSender sender = senderMap.get(notification.getType());
            if (sender != null) {
                sender.send(notification);
            } else {
                System.out.println("No sender found for notification type: " + notification.getType());
            }
        }
    }