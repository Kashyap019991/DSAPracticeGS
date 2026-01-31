package org.kas.demos.Prac.CoderpatQuest.DAY23_21_10.NotificationSystem;

public interface NotificationSender {
        void send(Notification notification);
        NotificationType getSupportedType();
    }